package com.company;

public class AdjacencyMatrix {
    int[][] M;

    public AdjacencyMatrix(int size){
        M = new int[size][size];
    }

    public void addEdge(int a, int b){
        M[a][b] = 1;
    }

    public void removeEdge(int a, int b){
        M[a][b] = 0;
    }
}
