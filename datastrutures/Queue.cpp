#include <iostream>

class Element{
public:
    int value;
    Element* next = nullptr;
    explicit Element(int value) {
        this->value = value;
    }
};

class Queue{
public:
    Element* head = nullptr;
    Element* tail = nullptr;
    int current_length = 0;
    int max_length{};


    [[nodiscard]] bool isEmpty() const{
        if (current_length == 0) return true;
        else return false;
    }

    void enqueue(int value){
        if(current_length == max_length){
            std::cout << "Queue is full!!";
            return;
        } else {
            auto *new_element = new Element(value);
            if(current_length == 0) {
                head = new_element;
                tail = new_element;
            }
            else {
                tail->next = new_element;
                tail = new_element;
            }
            current_length++;
        }
    }

    int dequeue(){
        if(isEmpty()){
            std::cout << "Queue is empty!!";
            return 0;
        } else {
            Element *to_return = head;
            head->next = head;
            current_length--;
            return to_return->value;
        }
    }

    void print() const{
        if(isEmpty()){
            std::cout << "Queue is empty" << std::endl;
            return;
        } else {
            Element *buffer = head;
            for (int i = 0; i < current_length; i++) {
                std::cout << buffer->value << std::endl;
                buffer = buffer->next;
            }
        }
    }
};

int main() {
    Queue Q;
    int max;
    std::cout << "Give max length: ";
    std::cin >> max;
    Q.max_length = max;
    for(int i=0; i<Q.max_length+2; i++){
        std::cout <<"iteration: " << i <<std::endl;
        Q.enqueue(i);
    }
    std::cout << "print:" << std::endl;
    Q.print();
    std::cout << "current length:" <<Q.current_length << std::endl;

    for(int i=0; i<Q.current_length+1; i++)
        std::cout << "dequeue" << Q.dequeue() << std::endl;

    return 0;
}
