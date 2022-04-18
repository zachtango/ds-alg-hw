package com.company.six_threefour;

public class BinomialQueue<AnyType extends Comparable<? super AnyType>>{
    public BinomialQueue(){}
    public BinomialQueue(AnyType item){}

    // merge trees in H1 and H2, make H2 empty and place results in H1
    public void merge( BinomialQueue<AnyType> rhs ){
        if(this == rhs) // avoid aliasing problems
            return;

        currentSize += rhs.currentSize;

        if( currentSize > capacity() ){
            int maxLength = Math.max(trees.length, rhs.trees.length);
            expandTrees(maxLength + 1);
        }

        Node<AnyType> carry = null;
        for(int i = 0, j = i; j <= currentSize; i++, j*=2){
            Node<AnyType> t1 = trees[i];
            Node<AnyType> t2 = i < rhs.trees.length ? rhs.trees[i] : null;

            int whichCase = t1 == null ? 0 : 1;
            whichCase += t2 == null ? 0 : 2;
            whichCase += carry == null ? 0 : 4;

            switch(whichCase){
                case 0: // no trees
                case 1:
                    break;
                case 2: // only rhs
                    trees[i] = t2;
                    rhs.trees[i] = null;
                    break;
                case 4: // only carry
                    trees[i] = carry;
                    carry = null;
                    break;
                case 3: // this and rhs
                    carry = combineTrees(t1, t2);
                    trees[i] = rhs.trees[i] = null;
                    break;
                case 5: // this and carry
                    carry = combineTrees(t1, carry);
                    trees[i] = null;
                    break;
                case 6: //  rhs and carry
                    carry = combineTrees(t2, carry);
                    rhs.trees[i] = null;
                    break;
                case 7: // all three
                    trees[i] = carry;
                    carry = combineTrees(t1, t2);
                    rhs.trees[i] = null;
                    break;
            }
        }

        for(int k = 0; k < trees.length; k++)
            rhs.trees[k] = null;

        rhs.currentSize = 0;
    }

    public void insert( AnyType x ){
        if(currentSize == 0){
            trees[0] = new Node<AnyType>(x);
            return;
        }


    }

//    public AnyType findMin(){}
//
//    public AnyType deleteMin(){}

    public boolean isEmpty(){ return currentSize == 0; }

    public void makeEmpty(){}

    private static class Node<AnyType>{

        AnyType element;
        Node<AnyType> leftChild, nextSibling;

        Node( AnyType elem ){
            this(elem, null, null);
        }

        Node(AnyType elem, Node<AnyType> lt, Node<AnyType> nt){
            element = elem; leftChild = lt; nextSibling = nt;
        }
    }

    private static final int DEFAULT_TREES = 1;

    private int currentSize; // number of items in prio queue
    private Node<AnyType> [] trees; // array of tree roots

    private int capacity(){
        return ((1 << trees.length) - 1);
    }

    private void expandTrees( int newTreeNum ){

    }

    private Node<AnyType> combineTrees( Node<AnyType> t1, Node<AnyType> t2 ){
        int c = t1.element.compareTo(t2.element);

        if(c > 0)
            return combineTrees(t2, t1);

        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;

        return t1;
    }


//    private int findMinIndex(){}
}
