package com.company;

import java.util.LinkedList;

public class Vertex {
    public LinkedList<Vertex> adj;
    public LinkedList<Integer> weights;
    public boolean known;
    public int dist;
    public Vertex path;

    public Vertex(){
        known = false;
        dist = 0;
    }
}
