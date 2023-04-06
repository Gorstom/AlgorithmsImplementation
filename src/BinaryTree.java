public class BinaryTree {
    //NIL = null
    Element root = null;

    public void InorderTreeWalk(Element x) { //wypisanie wszystkich elementów drzewa
        if(x!=null){
            InorderTreeWalk(x.left);
            System.out.println(x.value);
            InorderTreeWalk(x.right);
        }
    }



    public Element IterativeTreeSearch(Element x, int k){ //k - wartość szukana, //wyszukanie danej wartości
        while(x!=null && k != x.value){
            if(k < x.value)
                x=x.left;
            else x = x.right;
        }
        return x;
    }

    public Element TreeMinimum(Element x) {
        while (x.left !=null)
            x=x.left;
        return x;
    }

    public Element TreeMaximum(Element x){
        while(x.right !=null)
            x=x.right;
        return x;
    }

    public int TreePredecessor(Integer x){// wyznacznanie poprzednika węzła
        return 0;
    }

    public Element TreeSuccessor(Element x){ //wyznaczenie następnika węzła
        Element y;
        if(x.right!=null)
            return TreeMinimum(x.right);
        y=x.p;
        while((y.value != null) && (x == y.right)){
            x=y;
            y=y.p;
            return y;
        }

        return x;
    }

    public void TreeInsert(Element z){
        Element y=null;
        Element x = root;

        while(x != null) {
            y = x;
            if (z.value < x.value)
                x = x.left;
            else x = x.right;
        }
        z.p = y;
        if(y==null)
            root = z; //drzewo jest puste
        else if(z.value < y.value)
            y.left = z;
        else y.right = z;
    }

    public void TreeTransplant(Element u,Element v){
        if(u.p == null)
            root = v;
        else if(u == u.p.left)
            u.p.left=v;
        else u.p.right=v;
        if(v!=null)
            v.p = u.p;
    }

    public void TreeDelete(Element z){
        Element y = new Element(null);
        if (z.left==null)
            TreeTransplant(z, z.right);
        else if(z.right==null)
            TreeTransplant(z, z.left);
        else {
            y = TreeMinimum(z.right);
            if (y.p != z) {
                TreeTransplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            TreeTransplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }
}

