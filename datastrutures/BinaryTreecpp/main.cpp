#include <iostream>
#include "BinaryTree.cpp"

//
// Created by Tomasz on 28.05.2023.
//
int main(){
    BinaryTree bt;

    std::default_random_engine generator;
    std::uniform_int_distribution<int> distribution(1,2250);
    long int number;


    long long int size = 10000;
    Element* elements[size];

    for(long int i=0; i<size; i++){
        number = distribution(generator);
        elements[i] = new Element(number);
    }

    for(long int i=0; i<size; i++){
        bt.treeInsert(elements[i]);
    }

    for(long int i=0; i<2000; i++){
        bt.treeDelete(elements[i]);

    }

    for(long int i=0; i<4000; i++){
        std::cout<<"succesor elementu "<<i<<":             "<<bt.treeSuccessor(elements[i])->value;
        std::cout<<std::endl;
    }


    for(long int i=0; i<size; i++){
        std::cout<<"znaleziony klucz: "<<i<<": "<< (bt.iterativeTreeSearch(elements[0], elements[i]->value)->value);
        std::cout<<std::endl;

    }

    std::cout<<"minimum: "<<bt.treeMinimum(elements[0])->value;
    std::cout<<std::endl;
    std::cout<<"maximum: "<<bt.treeMaximum(elements[0])->value;


    return 0;
}