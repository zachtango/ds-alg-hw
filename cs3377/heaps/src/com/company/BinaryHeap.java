package com.company;

public class BinaryHeap{

    int[] A;
    int currentSize;

    public BinaryHeap(int capacity){
        currentSize = 0;
        A = new int[capacity];
    }

    public void insert(int element){
        if(currentSize == A.length){
            System.out.println("Can't add element. Array is full");
            return;
        }

        // perc up
        int hole = currentSize++;
        System.out.println("hole: " + hole);
        for(; element < A[hole / 2] && hole != 0; hole /= 2) {
            A[hole] = A[hole / 2];
        }

        A[hole] = element;
    }

    public int deleteMin(){
        int min = A[0];

        int hole = 0;

        // perc down
        while(leftChild(hole) < currentSize){
            int child = leftChild(hole);
            if(child + 1 < A.length && A[child] > A[child + 1])
                child++;

            A[hole] = A[child];

            hole = child;
        }

        System.out.println(hole + " " + A[currentSize - 1]);
        A[hole] = A[currentSize - 1];

        currentSize--;
        return min;
    }

    public void print(){
        System.out.print("Elements: ");
        for(int i = 0; i < currentSize; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    private int leftChild(int i){
        return 2 * i + 1;
    }

}
