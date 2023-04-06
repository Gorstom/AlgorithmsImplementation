public class Main {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        Element e1 = new Element(5);
        Element e2 = new Element(7);
        Element e3 = new Element(2);
        Element e4 = new Element(20);
        Element e5 = new Element(12);
        Element e6 = new Element(8);
        Element e7 = new Element(90);

        bt1.TreeInsert(e1);
        bt1.TreeInsert(e2);
        bt1.TreeInsert(e3);
        bt1.TreeInsert(e4);
        bt1.TreeInsert(e5);
        bt1.TreeInsert(e6);
        bt1.TreeInsert(e7);
        bt1.TreeTransplant(e2,e4);


        System.out.println("Inorder:");
        bt1.InorderTreeWalk(e1);
        System.out.println("minimum: "+bt1.TreeMinimum(e1).value);
        System.out.println("maximum: "+bt1.TreeMaximum(e1).value);
        System.out.println("wartość e2:"+e2.value);
        System.out.println("dziedzic e2: "+bt1.TreeSuccessor(e2).value);
        bt1.TreeDelete(e7);
        bt1.InorderTreeWalk(e1);
        System.out.println("iterative tree search: "+bt1.IterativeTreeSearch(e1,8));


    }
}
