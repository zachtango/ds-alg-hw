package com.company.nine_three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// representation of a graph
public class AdjacencyList<AnyType>{
    ArrayList<Vertex<AnyType>> vertices;
    int numVertices;

    public AdjacencyList(Vertex<AnyType>... vertices) {
        this.vertices = new ArrayList<>();
        numVertices = 0;
        for(Vertex<AnyType> v : vertices){
            this.vertices.add(v);
            numVertices++;
        }
    }

    public void addVertex(Vertex<AnyType> v) {
        vertices.add(v);
        numVertices++;
    }

    // topological sorting function that orders the vertices and prints them out in their order
    public void topsort() throws Exception{
        Queue<Vertex<AnyType>> q = new LinkedList<>();
        int order = 0;

        vertices.forEach(v -> {
            if(v.indegree == 0)
                q.add(v);
        });

        while(!q.isEmpty()){
            Vertex<AnyType> v = q.remove();
            v.topOrder = ++order;


            int numAdjacentVertices = v.adjacentVertices.size();
            for(int i = 0; i < numAdjacentVertices; i++){
                Vertex<AnyType> w = v.adjacentVertices.get(i);

                if(--w.indegree == 0)
                    q.add(w);
            }

            System.out.print(v.v + " ");
        }
        System.out.println();
        if(order != numVertices)
            throw new Exception();
    }
}
