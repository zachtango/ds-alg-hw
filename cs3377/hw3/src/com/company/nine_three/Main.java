package com.company.nine_three;

public class Main {
    public static void main(String[] args){
        // creating vertices for acyclic graph
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");
        Vertex<String> H = new Vertex<>("H");
        Vertex<String> I = new Vertex<>("I");
        Vertex<String> S = new Vertex<>("S");
        Vertex<String> T = new Vertex<>("T");
        // connecting vertices for acyclic graph
        A.addAdjacentVertices(B, E);
        B.addAdjacentVertices(C);
        C.addAdjacentVertices(T);
        D.addAdjacentVertices(A, E);
        E.addAdjacentVertices(C, F, I);
        F.addAdjacentVertices(C, T);
        G.addAdjacentVertices(D, E, H);
        H.addAdjacentVertices(E, I);
        I.addAdjacentVertices(F, T);
        S.addAdjacentVertices(A, D, G);

        // creating vertices for cyclic graph
        Vertex<String> A1 = new Vertex<>("A");
        Vertex<String> B1 = new Vertex<>("B");
        Vertex<String> C1 = new Vertex<>("C");
        Vertex<String> D1 = new Vertex<>("D");
        Vertex<String> E1 = new Vertex<>("E");
        Vertex<String> F1 = new Vertex<>("F");
        Vertex<String> G1 = new Vertex<>("G");
        // connecting vertices for cyclic graph
        A1.addAdjacentVertices(B1, C1);
        B1.addAdjacentVertices(C1, E1, G1);
        C1.addAdjacentVertices(D1, E1);
        D1.addAdjacentVertices(F1, A1);
        E1.addAdjacentVertices(F1, D1);
        G1.addAdjacentVertices(E1);

        // creation of graphs for testing
        AdjacencyList<String> acyclicGraph = new AdjacencyList<>(A, B, C, D, E, F, G, H, I, S, T);
        AdjacencyList<String> cyclicGraph = new AdjacencyList<>(A1, B1);

        // testing acyclic graph
        try{
            System.out.print("Acyclic Graph Topological Sort: ");
            acyclicGraph.topsort();
        } catch(Exception error){
            System.out.println("Cycle encountered");
        }

        // testing cyclic graph
        try{
            System.out.print("Cyclic Graph Topological Sort (error should be encountered): ");
            cyclicGraph.topsort();
        } catch(Exception error){
            System.out.println("ERROR: Cycle Encountered");
        }
    }
}
