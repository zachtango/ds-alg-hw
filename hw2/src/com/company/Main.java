package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // 3.21, 4.8, 4.22, 4.26, 4.27, 4.37, 5.1, 5.3, 5.5
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(12);
        tree.insert(16);
        tree.insert(13);
        tree.insert(-1);
        tree.insert(-5);
        tree.insert(0);
        tree.printTree();

        tree.print(-1, 12);
    }


}
