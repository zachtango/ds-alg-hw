package com.five_three;

import java.io.FileWriter;
import java.io.IOException;

public class GenRandomNumbersFile {
    public static void genFile(int min, int max){
        try{
            FileWriter writer = new FileWriter("randomnumbers.txt");

            // generate random number from min to max 1 million times and write it to the file
            for(int i = 0; i < 1000000; i++){
                writer.write(Integer.toString((int) Math.floor(Math.random() * (max - min + 1) + min)) + "\n");
            }

            writer.close();

            System.out.println("Wrote random numbers to file at ");
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
