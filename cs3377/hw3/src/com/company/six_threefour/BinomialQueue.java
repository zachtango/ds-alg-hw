package com.company.six_threefour;


public final class BinomialQueue<AnyType extends Comparable<? super AnyType>> {
    private static final int DEFAULT_TREES = 1;

    private int currentSize;                // # items in priority queue
    private Node<AnyType> [ ] trees;  // An array of tree roots


    public BinomialQueue( )
    {
        trees = new Node[ DEFAULT_TREES ];
        makeEmpty( );
    }

    /** README!!!
     * insert routine for problem 6.34
     */
    public void insert(AnyType element){
        Node<AnyType> carry;
        int i;

        // check if queue can fit another item
        if(++currentSize > capacity())
            expandTheTrees(trees.length + 10);

        // insertion process with carrying
        carry = new Node<>(element);
        i = 0;
        while(trees[i] != null){
            carry = combineTrees(carry, trees[i]);
            trees[i++] = null;
        }
        trees[i] = carry;
    }

    private void expandTheTrees( int newNumTrees )
    {
        Node<AnyType> [ ] old = trees;
        int oldNumTrees = trees.length;

        trees = new Node[ newNumTrees ];
        for( int i = 0; i < Math.min( oldNumTrees, newNumTrees ); i++ )
            trees[ i ] = old[ i ];
        for( int i = oldNumTrees; i < newNumTrees; i++ )
            trees[ i ] = null;
    }

    // merge 2 binomial trees t1 and t2 and return the result
    private Node<AnyType> combineTrees( Node<AnyType> t1, Node<AnyType> t2 )
    {
        if( t1.element.compareTo( t2.element ) > 0 )
            return combineTrees( t2, t1 );
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    // get smallest item in bin queue
    public AnyType findMin( )
    {
        if( isEmpty( ) ) {
            System.out.println("Error: tree is empty");
            return null;
        }

        return trees[ findMinIndex( ) ].element;
    }


    // find index of min node
    private int findMinIndex( )
    {
        int i;
        int minIndex;

        for( i = 0; trees[ i ] == null; i++ )
            ;

        for( minIndex = i; i < trees.length; i++ )
            if( trees[ i ] != null &&
                    trees[ i ].element.compareTo( trees[ minIndex ].element ) < 0 )
                minIndex = i;

        return minIndex;
    }

    // test if bin queue is empty
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    // make the bin queue empty
    public void makeEmpty( )
    {
        currentSize = 0;
        for( int i = 0; i < trees.length; i++ )
            trees[ i ] = null;
    }

    // Tree Node class
    private static class Node<AnyType>
    {
        // Constructors
        Node( AnyType theElement )
        {
            this( theElement, null, null );
        }

        Node( AnyType element, Node<AnyType> leftChild, Node<AnyType> nextSibling )
        {
            this.element = element;
            this.leftChild = leftChild;
            this.nextSibling = nextSibling;
        }

        AnyType          element;     // The data in the node
        Node<AnyType> leftChild;   // Left child
        Node<AnyType> nextSibling; // Right child
    }

    // return the amt of items tree can hold
    private int capacity( )
    {
        return ( 1 << trees.length ) - 1;
    }

}
