class Element{

    Element(Integer value) {
        this.value=value;
        //this.key=key;
    }

    Element(Integer value, Element left) {
        this.value=value;
        this.left=left;
        //this.key=key;
    }

    Element(Integer value, Element left, Element right) {
        this.value=value;
        this.left=left;
        this.right=right;
        //this.key=key;
    }
    Element(Integer value, Element left, Element right, Element p) {
        this.value=value;
        this.left=left;
        this.right=right;
        this.p=p;
        //this.key=key;
    }


    public Integer value;
    public Element left; //lewy syn danego węzła
    public Element right; //prawy syn danego węzła
    public Element p; //ojciec danego węzła

    @Override
    public String toString(){
        return value.toString();
    }
    //public Integer key;
}
