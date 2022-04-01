package com.five_five;

public class Main {

    public static void main(String[] args) {
        SeparateChainingHashTable<Integer> table = new SeparateChainingHashTable<>(12);

        // inserting elements into hash table
        // table size = nextPrime(12) = 13
        table.insert(10);
        table.insert(11);
        table.insert(33); // collides with 10 --> added to chain at the hash index
        table.insert(36);
        table.insert(21);
        table.insert(5);
        table.insert(6);

        // test insert
        table.print();

        table.remove(10);
        table.remove(33);
        table.remove(5);
        table.remove(21);

        // test remove
        table.print();

        System.out.println("Table contains 10?: " + table.contains(10));
        System.out.println("Table contains 2?: " + table.contains(2));
        System.out.println("Table contains 1?: " + table.contains(1));
        System.out.println("Table contains 11?: " + table.contains(11));
    }
}
