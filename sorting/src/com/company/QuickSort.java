package com.company;

public class QuickSort {
    // average running time O(nlogn)
    // O(n^2) worst case but can be made exponentially unlikely
    // choose a pivot randomly (3 median partition)
    // recursively sort first, third groups and then concat the 3 grps
    // 2nd grp are items eql to pivot
    /*
        Classic Quicksort Implementation
            sorts array S
        1. If the number of elements in S is 0 or 1, then return
        2. Pick any element v in S called the pivot
        3. Partition S - {v} (remaining elem in S) into 2 disjoint grps
            grp1 <= v, grp2 >= v
        4. Return {quicksort(grp1) followed by v followed by quicksort(grp2)}
     */
    /*
        Median of 3
        pick left, right, and center elem
        choose median of these 3 as the pivot
     */
    /*
        Partition Strat
        1. get pivot element out of way by swapping it w last elem
        2. flags i and j at start and end - 1
        3. while i is to left of j, move i right, skipping over elems
            smaller than the pivot. move j left skipping over elems larger than
            pivot
        4. stop i at first elem that's larger than or equal to pivot
            stop j at first elem smaller than or equal to pivot
            swap i and j
        5. continue iterating i and j
        6. finally, i and j have crossed, so swap pivot and i
     */

    int[] A;

    public QuickSort(int[] A){
        this.A = A;
    }
    public void sort(){
        sort(0, A.length - 1);
    }
    /*
        Partition Strat
        1. get pivot element out of way by swapping it w last elem
        2. flags i and j at start and end - 1
        3. while i is to left of j, move i right, skipping over elems
            smaller than the pivot. move j left skipping over elems larger than
            pivot
        4. stop i at first elem that's larger than or equal to pivot
            stop j at first elem smaller than or equal to pivot
            swap i and j
        5. continue iterating i and j
        6. finally, i and j have crossed, so swap pivot and i
     */
    private void sort(int left, int right){
        if(right - left <= 0)
            return;

        int center = (left + right) / 2;
        // pick pivot median of 3
        int pivot;
        if(A[left] < A[right])
            if(A[left] > A[center])
                pivot = left;
            else if(A[center] < A[right])
                pivot = center;
            else
                pivot = right;
        else // A[right] <= A[left]
            if(A[right] > A[center])
                pivot = right;
            else if(A[center] < A[left])
                pivot = center;
            else
                pivot = left;

        // swap pivot w/ last elem
        int pivotValue = A[pivot];
        A[pivot] = A[right];
        A[right] = pivotValue;

        System.out.println("Pivot: " + pivotValue);
        print();
        // partition S - {v} into 2 disjoint groups S1 and S2
        int i = left;
        int j = right - 1;

        while(i < j){
            while(i < right - 1 && A[i] < pivotValue) // skip over elems less than pivot for i
                i++;
            while(j > 0 && A[j] > pivotValue) // skip over elems greater than pivot for j
                j--;

            System.out.println("Pivot: " + pivotValue);
            print();
            System.out.println("i and j: " + i + " " + j);
            if(i < j) {
                // swap A[i] and A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }

        // swap A[i] and pivot
        int temp = A[i];
        A[i] = pivotValue;
        A[right] = temp;
        print();
        // recursively solve S1 and S2
        sort(left, i - 1);
        sort(i + 1, right);
    }

    public void print(){
        System.out.print("Array: ");
        for(int elem : A)
            System.out.print(elem + " ");
        System.out.println();
    }
}
