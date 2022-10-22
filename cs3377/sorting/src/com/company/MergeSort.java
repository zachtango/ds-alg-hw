package com.company;

public class MergeSort {
    /*
        O(nlogn)
        divide and conquer
    */

    int[] A;
    int[] temp;

    public MergeSort(int[] A){
        this.A = A;
        temp = new int[A.length];
    }

    public void sort(){
        sort(A, temp, 0, A.length - 1);
    }

    private void sort(int[] A, int[] temp, int left, int right){
        if(left == right)
            return;

        int numElements = right - left + 1;
        int center = (left + right) / 2;

        sort(A, temp, left, center);
        sort(A, temp, center + 1, right);

        int leftIndex = left;
        int rightIndex = center + 1;
        int index = 0;

        while(leftIndex < center + 1 && rightIndex <= right){
            if(A[leftIndex] < A[rightIndex])
                temp[index] = A[leftIndex++];
            else
                temp[index] = A[rightIndex++];
            index++;
        }

        // copy rest of elems left
        while(leftIndex < center + 1){
            temp[index++] = A[leftIndex++];
        }
        while(rightIndex <= right){
            temp[index++] = A[rightIndex++];
        }

        for(int i = 0; i < numElements; i++)
            A[left + i] = temp[i];
    }

    public void print(){
        System.out.print("Array: ");
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }
}
