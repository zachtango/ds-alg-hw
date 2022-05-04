package com.company;

public class DisjointSets {

    private int[] s;
    int roots;

    public DisjointSets(int numElements){
        s = new int[numElements];

        for(int i = 0; i < s.length; i++)
            s[i] = -1;

        roots = numElements;
    }

    /**
     * Union two disjoint sets by height
     * assume root1 and root2 are distinct
     * and represent set names
     * @param root1 root of set 1
     * @param root2 root of set 2
     */
    public void union(int root1, int root2){
        if(s[root2] < s[root1])
            s[root1] = root2;
        else{
            if(s[root1] == s[root2])
                s[root1]--;

            s[root2] = root1;
        }

        roots--;
    }

    /**
     * perform a find
     * @param x elem being searched for
     * @return set containing x
     */
    public int find(int x){
        if(s[x] < 0) {
            return x;
        }

        return find(s[x]);
    }

    public void print(){

        for(int i = 0; i < s.length / 2; i++){
            System.out.print(i + ": " + s[i] + ", ");
        }
        System.out.println();
        for(int i = s.length / 2; i < s.length; i++){
            System.out.print(i + ": " + s[i] + ", ");
        }
    }
}
