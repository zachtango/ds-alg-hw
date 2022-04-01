package com.five_five;

public class SeparateChainingHashTable<AnyType>{
    private static final int DEFAULT_TABLE_SIZE = 20;

    private SinglyLinkedList<AnyType>[] table;
    private int currentSize = 0;

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int tableSize){
        table = new SinglyLinkedList[tableSize];
        for(int i = 0; i < tableSize; i++){
            table[i] = new SinglyLinkedList<>();
        }
    }

    public void print(){
        System.out.println("SEPARATE CHAINING TABLE USING SINGLY LINKED LISTS-------------");
        System.out.println("Table Size: " + table.length);
        System.out.println("Num elements: " + currentSize);
        for(int i = 0; i < table.length; i++){
            System.out.print("index " + i + ": ");
            table[i].print();
        }
    }

    public void insert( AnyType x ){
        SinglyLinkedList<AnyType> whichList = table[myhash(x)];
        if(!whichList.contains(x)) {
            // add node to chain at index myhash(x)
            whichList.add(x);
            currentSize++;
        }
    }

    public void remove( AnyType x ){
        SinglyLinkedList<AnyType> whichList = table[myhash(x)];
        if(whichList.contains(x)){
            // remove node from chain at index myhash(x) that has element x
            whichList.remove(x);
            currentSize--;
        }
    }

    public boolean contains( AnyType x ){
        SinglyLinkedList<AnyType> whichList = table[myhash(x)];
        return whichList.contains(x);
    }

    // hash function is simply h(x) = x % table.length where table.length is a prime number
    private int myhash(AnyType x){
        int hashVal = x.hashCode();

        hashVal %= table.length;

        if(hashVal < 0)
            hashVal += table.length;

        return hashVal;
    }
}
