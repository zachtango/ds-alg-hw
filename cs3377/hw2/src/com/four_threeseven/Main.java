package com.four_threeseven;

public class Main {

    public static void main(String[] args) {
        // gen tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(20);
        bst.insert(31);
        bst.insert(3);
        bst.insert(-30);
        bst.insert(-20);
        bst.insert(40);

        System.out.println("Keys between -12 and 20");
        printBetween(bst.root, -12, 20);

    }

    public static void printBetween(BinarySearchTree.BinaryNode T, Comparable k1, Comparable k2){

        int compResult = k1.compareTo(k2);

        if(compResult > 0) { // error k1 supposed to be less than or equal to k2
            System.out.println("k1 must be less than or equal to k2");
            return;
        }

        if(T == null)
            return;

        int key1Comp = k1.compareTo(T.element);
        int key2Comp = k2.compareTo(T.element);

        if(key1Comp <= 0 && key2Comp >= 0){
            System.out.print(T.element + " ");
            printBetween(T.left, k1, k2);
            printBetween(T.right, k1, k2);
        } else if(key1Comp > 0) {
            printBetween(T.right, k1, k2);
        } else{
            printBetween(T.left, k1, k2);
        }

    }
}
