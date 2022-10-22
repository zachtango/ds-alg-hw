package com.company;

public class Kruskals {
    /*
        continually select edges in order of smallest weight
        and accept an edge if it doesn't cause a cycle

        uses disjoint sets
        each stage, choose lowest weighted edge
            if vertices u and v connected by the edge
            are in the same set, then reject it cus that means
            theres already a path from u to v and adding an edge between them
            would create a cycle

            else union u and v
            move on

        do these stages until all vertices in same set
     */
}
