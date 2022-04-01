package com.four_twosix;

public class AvlNode<AnyType> {
    AnyType element;
    AvlNode<AnyType> left;
    AvlNode<AnyType> right;

    public AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> r){
        AvlNode<AnyType> leftHolder = r.left;
        AvlNode<AnyType> leftRightHolder = r.left.right;

        r.left = leftRightHolder.right;
        leftRightHolder.right = r;

        leftHolder.right = leftRightHolder.left;
        leftRightHolder.left = leftHolder;

        return leftRightHolder;
    }

    public AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> r){
        AvlNode<AnyType> rightHolder = r.right;
        AvlNode<AnyType> rightLeftHolder = r.right.left;

        r.right = rightLeftHolder.left;
        rightLeftHolder.left = r;

        rightHolder.left = rightLeftHolder.right;
        rightLeftHolder.right = rightHolder;

        return rightLeftHolder;
    }

    AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public void printLevelOrder(){
        int h = height(this);
        for(int i = 1; i <= h; i++) {
            printCurrentLevel(this, i);
            System.out.println();
        }
    }

    int height(AvlNode root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printCurrentLevel(AvlNode root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.element + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

}
