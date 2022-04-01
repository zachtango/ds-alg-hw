package com.five_five;

// Singly Linked List Implementation
public class SinglyLinkedList<AnyType> {
    Node root;

    public void print(){
        Node i = root;
        if(i == null) {
            System.out.println("null");
            return;
        }

        while(i != null){
            System.out.print(i.data + " ");
            i = i.next;
        }

        System.out.println();
    }

    public void add(AnyType x){

        if(root == null){
            root = new Node(x);
            return;
        }

        Node i = root;
        while(i.next != null)
            i = i.next;

        i.next = new Node(x);
    }

    public void remove(AnyType x){
        if(root == null)
            return;

        if(x.equals(root.data)){
            root = root.next;
            return;
        }

        Node i = root;
        while(i != null && i.next != null){
            if(x.equals(i.next)) {
                i.next = i.next.next;
                break;
            }

            i = i.next;
        }
    }

    public boolean contains(AnyType x){
        Node i = root;
        while(i != null){
            if(x.equals(i.data))
                return true;
            i = i.next;
        }

        return false;
    }

    private class Node{
        AnyType data;
        Node next;

        Node(AnyType x){
            data = x;
            next = null;
        }
    }

}
