package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int A[] = new int[20];

        for(int i = 0; i < A.length; i++){
            Random rand = new Random();
            A[i] = rand.nextInt(50);
        }

        QuickSort Q = new QuickSort(A);
        Q.print();
        Q.sort();

//        RadixSort R = new RadixSort(A, 1);
//        R.print();
//        R.sort();
//        R.print();

//        CountingSort C = new CountingSort(A, 50);
//        C.print();
//        C.sort();
//        C.print();

//        MergeSort M = new MergeSort(A);
//        M.print();
//        M.sort();
//        M.print();

//        HeapSort H = new HeapSort(A);
//        H.print();
//        H.sort();
//        H.print();

//        InsertionSort S = new InsertionSort(A);
//        S.print();
//        S.sort();
//        S.print();

    }
}
