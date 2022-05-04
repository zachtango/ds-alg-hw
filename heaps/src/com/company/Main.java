package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinaryHeap heap = new BinaryHeap(20);

        for(int i = 19; i >= 0; i--)
            heap.insert(i);


        heap.print();
        heap.deleteMin();
        heap.print();
        heap.deleteMin();
        heap.print();
        heap.deleteMin();
        heap.print();
        heap.deleteMin();
        heap.print();
    }
}
