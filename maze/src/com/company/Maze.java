package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Maze {

    Cell M[][];
    DisjointSets S;
    int rows, cols, numCells;
    Set<Integer> path;

    public Maze(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        numCells = rows * cols;

        M = new Cell[rows][cols];
        path = new HashSet<>();

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                M[i][j] = new Cell(i * cols + j);

        S = new DisjointSets(rows * cols);
    }

    public class Cell{
        boolean n, e, s, w;
        int index;
        public Cell(int i){
            n = e = s = w = true;
            index = i;
        }
    }

    public void generateMaze(){
        while(S.roots > 1){
            // rand number between 0 and numCells
            int randomCell = (int) Math.floor(Math.random() * (numCells));
            // rand number between 0 and 3 (random direction)
            int randomWall = (int) Math.floor(Math.random() * 4);

            //System.out.println("Random Cell: " + randomCell);
            //System.out.println("Random Wall: " + randomWall);

            int i = randomCell / cols, j = randomCell % cols;

            Cell cell = M[i][j];
            Cell connected = null;

            // get connected cell
            switch(randomWall){
                case 0: // n
                    if(i == 0)
                        continue;
                    connected = M[i - 1][j];
                    break;
                case 1: // e
                    if(j == cols - 1)
                        continue;
                    connected = M[i][j + 1];
                    break;
                case 2: // s
                    if(i == rows - 1)
                        continue;
                    connected = M[i + 1][j];
                    break;
                default: // w
                    if(j == 0)
                        continue;
                    connected = M[i][j - 1];
            }

            //System.out.println("i, j: " + i + " " + j);

            // check if cell and connected cell are connected alrdy
            int root1 = S.find(cell.index), root2 = S.find(connected.index);
            if(root1 != root2){
                switch(randomWall){
                    case 0: // n
                        connected.s = false;
                        cell.n = false;
                        break;
                    case 1: // e
                        connected.w = false;
                        cell.e = false;
                        break;
                    case 2: // s
                        connected.n = false;
                        cell.s = false;
                        break;
                    default: // w
                        connected.e = false;
                        cell.w = false;
                }
                S.union(root1, root2);
            }
        }
    }

    public void print(){
        // first rows
        System.out.print("  ");
        for(int j = 0; j < cols - 1; j++){
            System.out.print(" -");
        }
        System.out.print("\n ");
        for(int j = 0; j < cols; j++){
            if(j == 0)
                System.out.print("S");
            else
                if(path.contains(j))
                    System.out.print("O");
                else
                    System.out.print("X");

            if(M[0][j].e)
                System.out.print("|");
            else
                System.out.print(" ");
        }
        System.out.println();
        for(int j = 0; j < cols; j++){
            if(M[0][j].s)
                System.out.print(" -");
            else
                System.out.print("  ");
        }
        System.out.println();
        // middle rows
        for(int i = 1; i < rows - 1; i++){
            System.out.print("|");
            for(int j = 0; j < cols; j++) {
                if(path.contains(i * cols + j))
                    System.out.print("O");
                else
                    System.out.print("X");
                if (M[i][j].e)
                    System.out.print("|");
                else
                    System.out.print(" ");
            }
            System.out.println();
            for(int j = 0; j < cols; j++){
                if(M[i][j].s)
                    System.out.print(" -");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        // last rows
        System.out.print("|");
        for(int j = 0; j < cols - 1; j++){
            if(path.contains((rows - 1) * cols + j))
                System.out.print("O");
            else
                System.out.print("X");
            if(M[4][j].e)
                System.out.print("|");
            else
                System.out.print(" ");
        }
        System.out.print("F\n");
        for(int j = 0; j < cols - 1; j++){
            System.out.print(" -");
        }
        System.out.println();
    }

    public void solve(){
        Stack<Cell> stack = new Stack<>();
        int i, j;
        Cell current = M[0][0];
        boolean visited[] = new boolean[rows * cols];
        visited[0] = true;
        stack.push(current);

        int goal = rows * cols - 1;
        while(!visited[goal]){
            i = current.index / cols;
            j = current.index % cols;
//            System.out.println("i, j: " + i + " " + j);
            // get unvisited neighbors
            if(!current.n){
                int connectedIndex = (i - 1) * cols + j;
                if(!visited[connectedIndex]){
                    visited[connectedIndex] = true;
                    stack.push(M[i - 1][j]);
                    current = M[i - 1][j];
                    continue;
                }
            }
            if(!current.e){
                int connectedIndex = i * cols + j + 1;
                if(!visited[connectedIndex]){
                    visited[connectedIndex] = true;
                    stack.push(M[i][j + 1]);
                    current = M[i][j + 1];
                    continue;
                }
            }
            if(!current.s){
                int connectedIndex = (i + 1) * cols + j;
                if(!visited[connectedIndex]){
                    visited[connectedIndex] = true;
                    stack.push(M[i + 1][j]);
                    current = M[i + 1][j];
                    continue;
                }
            }
            if(!current.w){
                int connectedIndex = i * cols + j - 1;
                if(!visited[connectedIndex]){
                    visited[connectedIndex] = true;
                    stack.push(M[i][j - 1]);
                    current = M[i][j - 1];
                    continue;
                }
            }

            // reach this --> no neighbors --> deadend
            stack.pop();
            current = stack.peek();
        }

        System.out.print("\nRoute: ");
        while(!stack.empty()){
            int index = stack.pop().index;
            path.add(index);
            System.out.print(index + " ");
        }
        System.out.println();

        print();
    }
}
