package com.company;

public class InsertionSort {
    /*
        O(n^2)
        Input: Array A with n elements
        Algo: have 0 through p - 1 sorted for p = 1 ... n - 1
        since 0 ... p - 1 is sorted, keep on moving elements in p - 1
        to the right until a spot is found for element p
    */

    int A[];
    int n;

    public InsertionSort(int A[]){
        this.A = A;
        n = A.length;
    }

    public void sort(){
        int p = 1;
        while(p < A.length){
            int elem = A[p];
            int i = p; // i - 1 is holder for indices 0 ... p - 1
            while(i > 0 && A[i - 1] > elem){
                A[i] = A[i - 1];
                i--;
            }
            A[i] = elem; // once this point is reached, i is at indice where element at p belongs

            p++; // now 0 ... p is sorted so we have to increment p
        }
    }

    public void print(){
        System.out.print("List: ");
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }
}
