class ElementList {
    ElementList(int value){
        this.value = value;
    }
    public int value;
    public ElementList next=null;
}

public class List {
    ElementList head = null; //first element on list
    ElementList tail = null; //last element on list

    int length=0;


    public void add(int value) {
        ElementList a1 = new ElementList(value);
        if (isEmpty()){
            head=a1;
            tail=a1;
        }
        else{
            tail.next = a1;
            tail=a1;
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
            ElementList a = head;
            for (int i = 0; i < length-1; i++) {
                a = a.next;
            }
            tail=a;
        } else if(length==3 && index==1){ //what if i remove element from middle while i have 3 elements
            head.next = tail;
        } else if(length>3 && index>=0){ //what if i remove element from middle, and i have more than 3 elements - normal case
            ElementList previous = null;
            ElementList toDelete = head;

            for (int i = 0; i < index && toDelete != null; i++) {
                previous = toDelete;
                toDelete = toDelete.next;
            }

            if (toDelete == null) {
                System.out.println("There is no item with this index");
                return;
            }

            previous.next = toDelete.next;


        } else if(index>length+1 || index<0){
            System.out.println("There is no item with this index");
            return;
        }
        length--;
    }

    public Integer getValue(int index) {
        if (index >= length || index<0 ) {
            System.out.println("Given value doesn't exist on the list");
            return null;
        }
        else
        {
            ElementList a = head;
            for (int i = 0; i < index; i++)
            {
                a = a.next;
            }

            return a.value;
        }
    }

    public int getIndex(int value) {
        int index = 0;
            while (index <= length) {
                if (index >= length) {
                    System.out.println("Given index doesn't exist on the list");
                    return -1;
                }else{
                ElementList a = head;

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
        ElementList a = head;
        for (int i = 0; i < length; i++)
        {
            System.out.println(a.value);
            a = a.next;
        }
    }
}
