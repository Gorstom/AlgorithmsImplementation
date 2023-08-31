class ElementBT {

    ElementBT(Integer value) {
        this.value=value;
        //this.key=key;
    }


    public Integer value;
    public ElementBT left; //left son of a given node
    public ElementBT right; //right son of a given node
    public ElementBT p; //parent of a given node

    @Override
    public String toString(){
        return value.toString();
    }
}

public class BinaryTree {
    public ElementBT root = null;

    public void inorderTreeWalk(ElementBT x) { //print all elements of the tree
        if(x!=null){
            inorderTreeWalk(x.left);
            System.out.println(x.value);
            inorderTreeWalk(x.right);
        }
    }



    public ElementBT iterativeTreeSearch(ElementBT x, int k){ //k - seeked value, //search given value
        while(x!=null && k != x.value){
            if(k < x.value)
                x=x.left;
            else x = x.right;
        }
        return x;
    }

    public ElementBT treeMinimum(ElementBT x) {
        ElementBT y = null; // poprzednik
        while (x !=null) {
            y = x;
            x = x.left;
        }
        return y;
    }

    public ElementBT treeMaximum(ElementBT x) {
        ElementBT y = null; // poprzednik
        while (x != null) {
            y = x;
            x = x.right;
    }
        return y;
    }

    public int treePredecessor(Integer x){// searching the predecessor of the node
        return 0;
    }

    public ElementBT treeSuccessor(ElementBT x){ //searching the successor of the node
        ElementBT y;
        if(x.right!=null)
            return treeMinimum(x.right);
        y=x.p;
        while((y.value != null) && (x == y.right)){
            x=y;
            y=y.p;
        }
        return y;
    }

    public void treeInsert(int value){
        ElementBT z = new ElementBT(value);
        ElementBT y = null;
        ElementBT x = root;

        while(x != null) {
            y = x;
            if (z.value < x.value)
                x = x.left;
            else x = x.right;
            }
        z.p = y;
        if(y==null)
            root = z; //tree is empty
        else if(z.value < y.value)
            y.left = z;
        else y.right = z;
    }

    public void transplant(ElementBT u, ElementBT v){
        if(u.p == null)
            root = v;
        else if(u == u.p.left)
            u.p.left=v;
        else u.p.right=v;
        if(v!=null)
            v.p = u.p;
    }

    public void treeDelete(int value){
        ElementBT z = iterativeTreeSearch(root, value);
        ElementBT y;
        if(z==null) return;

        if (z.left==null)
            transplant(z, z.right);
        else if(z.right==null)
            transplant(z, z.left);
        else {
            y = treeMinimum(z.right);
            if (y.p != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }
}

