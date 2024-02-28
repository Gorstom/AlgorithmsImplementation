#include <iostream>

class Element{
public:
    Element* next = nullptr;
    int value;

    Element(long int value){
        this->value = value;
        next = nullptr;
    }
};

class List{
public:
    Element* head = nullptr;
    Element* tail = nullptr;
    int length=0;


    void add_after_element(int value, int index){
        if (index < 0 || index >= length) {
            // invalid index
            std::cout << "Invalid index" << std::endl;
            return;
        }

        Element* temp = new Element(value);
        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            Element* after = get(index);
            if (after == tail) {
                tail->next = temp;
                tail = temp;
            } else {
                // Inserting in the middle
                temp->next = after->next;
                after->next = temp;
            }
        }

        length++;
    }

    void append(int value){
        Element* temp = new Element(value);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }
        else{
            tail->next=temp;
            tail=temp;
        }
        length++;
    }

    void add_to_start(int value){
        Element* temp = new Element(value);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }
        else{
            temp->next=head;
            head=temp;
        }
        length++;
    }

    void deleteAt(int index){
        Element* temp;
        if(isEmpty()){//what if list is empty
            std::cout<<"list is empty!!";
            return;
        }

        if(index==0 && length>1){ //what if I remove the first element and the size is greater than 1
            head = head->next;
        }else if(index==0 && length==1){//what if I remove the first element and I have 1 element
            head= nullptr;
            tail=nullptr;
        } else if(index==length-1){ //what if i delete the last item
            temp = head;
            for (int i = 0; i < length-1; i++) {
                temp = temp->next;
            }
            tail=temp;
        } else if(length==3 && index==1){ //what if I remove an element from the middle while I have 3 elements
            head->next = tail;
        } else if(length>3 && index < length-1){ //what if I remove an element from the middle, and I have more than 3 elements - normal case
            Element* previous;
            Element* toDelete = head;
            for (int i = 0; i < index; i++) {
                previous = toDelete;
                toDelete = toDelete->next;
            }
            previous->next= toDelete->next;
        }
        else std::cout<<"There's no element with given index"<<std::endl;
        length--;
    }

    Element* get(int index){
        if(index >= length){
            std::cout<<"Does not exists on the list";
            return NULL;
        }
        else{
            Element* temp = head;
            for(int i =0; i<index; i++){
                temp = temp->next;
            }
            return temp;
        }
    }


    bool isEmpty() {
        if (head == nullptr)
            return true;
        else { return false; }
    }

    void print() {
        Element* temp = head;
        for(int i=0; i < length; i++){
            std::cout << temp->value << std::endl;
            temp = temp->next;
        }
    }
};