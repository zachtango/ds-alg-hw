package com.company;

public class CountingSort {
    /*
        time is O(M + N) where M is the max integer in the array A
        N is the number of elements in array A
     */

    int max;
    int[] A;
    int[] count;

    public CountingSort(int[] A, int max){
        this.max = max;
        this.A = A;
        count = new int[max + 1];
    }

    public void sort(){
        for(int i = 0; i < A.length; i++)
            count[A[i]]++;

        int i = 0;
        for(int j = 0; j < count.length; j++)
            for(int k = 0; k < count[j]; k++, i++)
                A[i] = j;
    }

    public void print(){
        System.out.print("Array: ");
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }
}
