package com.company.six_threefour;

public class Main {
    public static void main(String[] args ){
        BinomialQueue<Integer> h  = new BinomialQueue<>();

        // insert elements
        h.insert(5);
        h.insert(3);
        h.insert(7);
        h.insert(6);
        h.insert(1000);
        h.insert(14);

        // test if inserted correctly
        System.out.println("Minimum Element: " + h.findMin());
        // insert another
        h.insert(-10);
        // test
        System.out.println("Minimum Element after inserting -10: " + h.findMin());
        // insert another
        h.insert(-1000);
        // test
        System.out.println("Minimum Element after inserting -1000: " + h.findMin());
        // insert another
        h.insert(-999);
        // test
        System.out.println("Minimum Element after inserting -999: " + h.findMin());
    }
}
