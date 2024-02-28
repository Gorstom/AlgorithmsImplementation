#include <iostream>
#include <random>

class Element {
public:
    long int value;
    Element* left;
    Element* right;
    Element* p;

    Element(long int value) {
        this->value = value;
        left = nullptr;
        right = nullptr;
        p = nullptr;
    }
};

class BinaryTree {
public:
    Element* root;

    BinaryTree() {
        root = nullptr;
    }

    void inorderTreeWalk(Element* x) {
        if (x != nullptr) {
            inorderTreeWalk(x->left);
            std::cout << x->value << std::endl;
            inorderTreeWalk(x->right);
        }
    }


    static Element* iterativeTreeSearch(Element* x, long int k) {
        while (x != nullptr && k != x->value) {
            if (k < x->value)
                x = x->left;
            else
                x = x->right;
        }
        return x;
    }

    static Element* treeMinimum(Element* x) {
        while (x->left != nullptr)
            x = x->left;
        std::cout << x->value;
        return x;
    }

    static Element* treeMaximum(Element* x) {
        while (x->right != nullptr)
            x = x->right;
        std::cout << x->value;
        return x;
    }

    static Element* treeSuccessor(Element* x) {
        if (x->right != nullptr)
            return treeMinimum(x->right);

        Element* y = x->p;
        while (y != nullptr && x == y->right) {
            x = y;
            y = y->p;
        }
        return y;
    }

    void treeInsert(Element* z) {
        Element* y = nullptr;
        Element* x = root;

        while (x != nullptr) {
            y = x;
            if (z->value < x->value)
                x = x->left;
            else
                x = x->right;
        }
        z->p = y;
        if (y == nullptr)
            root = z;
        else if (z->value < y->value)
            y->left = z;
        else
            y->right = z;
    }

    void treeTransplant(Element* u, Element* v) {
        if (u->p == nullptr)
            root = v;
        else if (u == u->p->left)
            u->p->left = v;
        else
            u->p->right = v;
        if (v != nullptr)
            v->p = u->p;
    }

    void treeDelete(Element* z) {
        if (z->left == nullptr)
            treeTransplant(z, z->right);
        else if (z->right == nullptr)
            treeTransplant(z, z->left);
        else {
            Element* y = treeMinimum(z->right);
            if (y->p != z) {
                treeTransplant(y, y->right);
                y->right = z->right;
                y->right->p = y;
            }
            treeTransplant(z, y);
            y->left = z->left;
            y->left->p = y;
        }
    }
};