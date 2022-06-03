package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

// base 10
public class RadixSort {
    int p; // max integer has 10 to power of p
    int[] A;
    LinkedList<Integer>[] buckets = new LinkedList[10];

    public RadixSort(int[] A, int p){
        this.A = A;
        this.p = p;

        for(int i = 0; i < 10; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public void sort(){
        int place;
        for(int i = 0; i <= p; i++){
            place = 1;

            for(int j = 0; j < i; j++)
                place *= 10;

            int k;
            // count by place in buckets
            for(k = 0; k < A.length; k++){
                int digit = (A[k] / place) % 10;
                buckets[digit].add(A[k]);
            }

            // sort array by elems in buckets
            k = 0;
            for(LinkedList<Integer> bucket : buckets){
                for(int num : bucket){
                    A[k] = num;
                    k++;
                }

                bucket.clear();
            }
        }
    }

    public void print(){
        System.out.print("Array: ");
        for(int elem : A)
            System.out.print(elem + " ");
        System.out.println();
    }
}
