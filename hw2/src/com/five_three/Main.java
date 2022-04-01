package com.five_three;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
            gen random sequence of 10000 numbers between the input min and max (already included in project name is "randomnumbers.txt")
            uncomment function to regenerate random numbers and overwrite "randomnumbers.txt" file
         */
        // GenRandomNumbersFile.genFile(0, 10000);

        DoubleHashTable<Integer> doubleHashTable = new DoubleHashTable<>();
        LinearProbingHashTable<Integer> linearProbingHashTable = new LinearProbingHashTable<>();
        QuadraticProbingHashTable<Integer> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        /*
            Read in all the random numbers from "randomnumbers.txt" and insert them all three hash tables
            This will print out the sequence of random numbers
            At the end, it will print out the number of collisions for each type of hashing
         */
        try{
            File file = new File("randomnumbers.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                int num = Integer.valueOf(data);
                System.out.println(num);
                linearProbingHashTable.insert(num);
                quadraticProbingHashTable.insert(num);
                doubleHashTable.insert(num);
            }

            System.out.println("Linear Probing Collisions: " + linearProbingHashTable.getCollisions());
            System.out.println("Quadratic Probing Collisions: " + quadraticProbingHashTable.getCollisions());
            System.out.println("Double Hash Collisions: " + doubleHashTable.getCollisions());
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
