package com.four_twosix;

public class Main {
    public static void main(String[] args) {
        // tree with case for double with right child rotation
        AvlNode<Integer> one = new AvlNode<>(6, null, null);
        one.left = new AvlNode<>(5, null, null);
        one.right = new AvlNode<>(15, new AvlNode<>(7, null, new AvlNode<>(14, null, null)), new AvlNode<>(16, null, null));

        System.out.println("Tree before rotation");
        one.printLevelOrder(); // print tree before rotation
        System.out.println();
        one = one.doubleWithRightChild(one); // test double with right child rotation
        System.out.println("Tree after rotation");
        one.printLevelOrder(); // print tree after rotation
        System.out.println();

        // tree with case for double with left child rotation
        AvlNode<String> two = new AvlNode<>("z", null, null);
        two.left = new AvlNode<>("y", new AvlNode<>("T1", null, null), new AvlNode<>("x", null, null));
        two.left.right.left = new AvlNode<>("T2", null, null);
        two.left.right.right = new AvlNode<>("T3", null, null);
        two.right = new AvlNode<>("T4", null, null);

        System.out.println("Tree before rotation");
        two.printLevelOrder(); // print tree before rotation
        System.out.println();
        two = two.doubleWithLeftChild(two); // test double with left child rotation
        System.out.println("Tree after rotation");
        two.printLevelOrder(); // print tree after rotation
        System.out.println();
    }


}
