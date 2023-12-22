class BiElement{
    BiElement(int value){
        this.value = value;
    }
    public int value;
    public BiElement previous=null;
    public BiElement next=null;
}

public class BidirectionalList {
    BiElement head = null; //first element on list
    BiElement tail = null; //last element on list

    int length=0;


    public void add(int value) {
        BiElement new_element = new BiElement(value);
        if (isEmpty()){
            head=new_element;
            tail=new_element;
        }
        else{
            new_element.previous = tail;
            new_element.next = head;
            head.previous = new_element;
            tail.next = new_element;
            tail = new_element;
        }
        length++;

    }

    public void deleteAt(int index)
    {
        if(isEmpty()){//what if list is empty
            System.out.println("List is empty!!");
            return;
        }

        if(index==0 && length>1){ //what if i delete the first element and the size is greater than 1
            head = head.next;
        }else if(index==0 && length==1){//what if i delete the first item and i have 1 element
            head=null;
            tail=null;
        } else if(index==length-1){ //what if i delete last element
            BiElement a = head;
            for (int i = 0; i < length-1; i++) {
                a = a.next;
            }
            tail=a;
        } else if(length==3 && index==1){ //what if i remove element from middle while i have 3 elements
            head.next = tail;
        }else if(length>3 && index>0 && index <=length/2){ //what if i remove element from middle, and i have more than 3 elements - normal case
            // wtedy sprawdzamy od początku
            BiElement nastepny = null;
            BiElement toDelete = head;
            for (int i = 0; i < index; i++) {
                nastepny = toDelete;
                toDelete = toDelete.next;
            }

            nastepny.next= toDelete.next;


        }

        else if(length>3 && index >=length/2 && index<=length+1){ ////what if i remove element from middle, and i have more than 3 elements, and index is in second half
            //then we iterate starting from the end

            BiElement previous = null;
            BiElement toDelete = tail;
            for (int i = length; i >= index; i--) {
                previous = toDelete;
                toDelete = toDelete.previous;
            }

            previous.next= toDelete.next;
        }
        else{
            System.out.println("There is no item with this index");
            return;
        }
        length--;
    }

    public Integer getValue(int index) {
        BiElement a = head;

        if (index >= length ) {
            System.out.println("Given value doesn't exist on the list");
            return null;
        }
        else if(length/2>=index) //if the given index is in the first half of the list, check from the beginning
        {

            for (int i = 0; i < index; i++)
            {
                a = a.next;
            }

            return a.value;
        }

        else if(length/2<index){ //if the given index is in the last half of the list, check from the end
            a = tail; //replace 'a' with tail to count from the end

            for (int i = length-1; i>index; i--){
                a = a.previous;
            }
            return a.value;
        }
        return a.value;
    }

    public int getIndex(int value) {
        int index = 0;
        while (index <= length) {
            if (index >= length) {
                System.out.println("Given value doesn't exist on the list");
                return -1;
            }else{
                BiElement a = head;

                for (int i = 0; i < length; i++) {
                    if (getValue(i) == value)
                        return index;
                    else {
                        a = a.next;
                        index++;
                    }
                }
            }
        }
        return index;
    }

    public boolean isEmpty()
    {
        if(head==null)
            //return head==null;
            return true;
        else return false;
    }



    public void print() {
        BiElement a = head;
        for (int i = 0; i < length; i++)
        {
            System.out.println(+a.value);
            a = a.next;
        }
    }
}
