package com.company.nine_three;

import java.util.LinkedList;

public class Vertex<AnyType>{
    AnyType v; // vertex name
    LinkedList<Vertex<AnyType>> adjacentVertices;
    int indegree; // number of vertices this vertex is adjacent to
    int topOrder; // for topological sorting purposes in an adjacency list

    public Vertex(AnyType vertex){
        v = vertex;
        indegree = 0;
        adjacentVertices = new LinkedList<>();
    }

    // for connecting this vertex to other vertices
    public void addAdjacentVertices(Vertex<AnyType>... vertices){
        for(Vertex<AnyType> w : vertices){
            adjacentVertices.add(w);
            w.indegree++;
        }
    }
}
