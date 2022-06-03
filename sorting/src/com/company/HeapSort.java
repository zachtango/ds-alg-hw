package com.company;

public class HeapSort {
    // O(nlogn)
    BinaryHeap H;
    int n;

    public HeapSort(int[] A){
        H = new BinaryHeap(A);
        n = H.currentSize;
    }

    public void sort(){
        for(int i = 0; i < n; i++){
            int min = H.deleteMin();
            H.A[H.currentSize] = min;
        }
    }

    public void print(){
        System.out.print("Heap: ");
        for(int i = 0; i < n; i++){
            System.out.print(H.A[i] + " ");
        }
        System.out.println();
    }
}
