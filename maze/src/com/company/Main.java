package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Maze maze = new Maze(5, 10);
        maze.generateMaze();
        maze.print();
        maze.solve();

    }
}
