package com.company;

public class BinaryHeap{

    int[] A;
    int currentSize;

    public BinaryHeap(int[] A){
        this.A = new int[A.length * 2];
        currentSize = A.length;

        for(int i = 0; i < A.length; i++)
            this.A[i] = A[i];

        buildHeap();
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
            if(child + 1 < currentSize && A[child] > A[child + 1])
                child++;

            A[hole] = A[child];

            hole = child;
        }

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

    //  assumes n elements inserted into A O(n)
    private void buildHeap(){

        // percolate down starting at last parent
        // index at currentSize / 2
        for(int i = currentSize / 2; i >= 0; i--){
            // perc down
            percDown(i);
        }

    }

    private void percDown(int i){
        int elem = A[i];

        // get smaller of 2 children
        int child = leftChild(i);
        if(child + 1 < currentSize && A[child] > A[child + 1])
            child++;

        int hole = i;
        while(child < currentSize && elem > A[child]){
            A[hole] = A[child];
            hole = child;

            // get smaller of 2 children
            child = leftChild(child);
            if(child + 1 < currentSize && A[child] > A[child + 1])
                child++;
        }

        A[hole] = elem;
    }

    private int leftChild(int i){
        return 2 * i + 1;
    }

}
