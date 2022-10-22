package com.three_twoone;

public class Main {
    public static void main(String[] args){
        // test pascal string
        String pascal1 = "begin{}()[][{()[]}]end";
        String pascal2 = "{}()[][{()[]}]end";
        String pascal3 = "begin{}()[][{()[]}]";
        String pascal4 = "{{}()][][{()[]}]";
        System.out.println(pascal1 + " is valid: " + BalanceChecker.pascal(pascal1));
        System.out.println(pascal2 + " is valid: " + BalanceChecker.pascal(pascal2));
        System.out.println(pascal3 + " is valid: " + BalanceChecker.pascal(pascal3));
        System.out.println(pascal4 + " is valid: " + BalanceChecker.pascal(pascal4));

        // test java string
        String java1 = "/*{}()[][{()[]}]*/";
        String java2 = "{}()[][{()[]}]*/";
        String java3 = "/*{}()[][{()[]}]";
        String java4 = "{{}(})][][{()[]}]";
        System.out.println(java1 + " is valid: " + BalanceChecker.java(java1));
        System.out.println(java2 + " is valid: " + BalanceChecker.java(java2));
        System.out.println(java3 + " is valid: " + BalanceChecker.java(java3));
        System.out.println(java4 + " is valid: " + BalanceChecker.java(java4));
    }
}
