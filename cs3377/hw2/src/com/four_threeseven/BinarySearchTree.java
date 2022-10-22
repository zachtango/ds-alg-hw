package com.four_threeseven;

import java.lang.Exception;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    static class BinaryNode<AnyType>{
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType elem){ this(elem, null, null); }

        BinaryNode(AnyType elem, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = elem;
            left = lt;
            right = rt;
        }
    }

    BinaryNode<AnyType> root;

    public BinarySearchTree(){ root = null; }

    public void makeEmpty(){ root = null; }

    public boolean isEmpty(){ return root == null; }

    public boolean contains(AnyType x){ return contains(x, root); }

    public AnyType findMin() throws Exception {
        if(isEmpty()) throw new Exception();

        return findMin(root).element;
    }

    public AnyType findMax() throws Exception{
        if(isEmpty()) throw new Exception();

        return findMax(root).element;
    }

    public void insert(AnyType x){ root = insert(x, root); }

    public void remove(AnyType x){ root = remove(x, root); }

    public void printTree(){
        if(isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> n){
        if(n == null)
            return false;

        int compResult = x.compareTo(n.element);

        if(compResult < 0)
            return contains(x, n.left);
        else if(compResult > 0)
            return contains(x, n.right);
        else
            return true;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t == null || t.left == null)
            return t;

        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if(t == null || t.right == null)
            return t;

        return findMax(t.right);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        if(t == null)
            return new BinaryNode<AnyType>(x);

        int compResult = x.compareTo(t.element);

        if(compResult < 0)
            t.left = insert(x, t.left);
        else if(compResult > 0)
            t.right = insert(x, t.right);
        else; // error can't have two nodes w/ same elem

        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if(t == null)
            return null;

        int compResult = x.compareTo(t.element);

        if(compResult < 0)
            t.left = remove(x, t.left);
        else if(compResult > 0)
            t.right = remove(x, t.right);
        else if(t.left != null && t.right != null){ // 2 children
            AnyType elem = findMax(t.left).element;
            t.left = remove(elem, t.left);
            t.element = elem;
        } else
            t = ( t.left != null ) ? t.left : t.right;

        return t;
    }

    private void printTree(BinaryNode<AnyType> t){
        if(t != null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

}
