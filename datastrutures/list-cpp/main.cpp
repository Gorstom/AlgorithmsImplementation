#include <iostream>
#include <random>
#include "list.cpp"

int main() {
    List list;

    std::default_random_engine generator;
    std::uniform_int_distribution<int> distribution(1, 2250);

    long int number;

    long long int size = 10;
    int elements[size];

    for (long int i = 0; i < size; i++) {
        number = distribution(generator);
        elements[i] = number;
    }

    std::cout << "Is list empty?   " << list.isEmpty() << std::endl;
    for (long int i = 0; i < size; i++) {
        list.append(elements[i]);
    }

    std::cout << std::endl << "--------LIST--------" << std::endl;
    list.print();
    std::cout << std::endl << "--------ARRAY--------" << std::endl;
    for (int i = 0; i < size; i++) {
        std::cout << elements[i] << std::endl;
    }

    std::cout << "Is list empty?   " << list.isEmpty() << std::endl;


    //test get()
//    std::cout<<"get:"<<std::endl;
//    for (int i = 0; i < size; i++){
//        std::cout << "element " << i << ": " << list.get(i)->value<<std::endl;
//}

    list.deleteAt(1);
    list.deleteAt(5);

    std::cout<<"--------AFTER DELETION-------"<<std::endl;
    list.print();

    std::cout<<"We want to remove an element that does not exist"<<std::endl;
    list.deleteAt(234234);



    //clear list
    while(!list.isEmpty()){
        list.deleteAt(0);
    }
    std::cout<<"After list clearance"<<std::endl;
    list.print();
    std::cout << "Is the list empty?   " << list.isEmpty() << std::endl;

    std::cout<<"We want to delete element, whil lsit is empty"<<std::endl;
    list.deleteAt(4);


    std::cout<<std::endl<<"add to start"<<std::endl;
    list.add_to_start(76);
    list.add_to_start(4);
    list.add_to_start(8);
    list.add_to_start(8);
    list.print();
    list.append(878);
    list.append(123);

    std::cout<<"-----------------------";
    std::cout<<std::endl<<"add after element "<<std::endl;
    list.add_after_element(6, 1);
    list.add_after_element(23232,5);

    list.print();


    return 0;
}
