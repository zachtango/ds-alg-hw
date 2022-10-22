package com.three_twoone;

import java.util.Stack;

public class BalanceChecker {
    /*
        ASSUMES INPUT IS CLEAN AND ONLY CONTAINS SYMBOLS AND NO SPACES
        SPECIFIED FROM HW PROBLEM: begin, end, (), [], {}
     */
    public static boolean pascal(String input){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            switch(c){
                case ')':
                    if(stack.empty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{')
                        return false;
                    break;
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;

                case 'b':
                    i += 4;
                    stack.push(c);
                    break;

                case 'e':
                    i+= 2;
                    if(stack.empty() || stack.pop() != 'b')
                        return false;
            }
        }

        return stack.empty();
    }

    /*
        ASSUMES INPUT IS CLEAN AND ONLY CONTAINS SYMBOLS AND NO SPACES
        SPECIFIED FROM HW PROBLEM: /asterisk, asterisk/, (), [], {}
     */
    public static boolean java(String input){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            switch(c){
                case ')':
                    if(stack.empty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{')
                        return false;
                    break;
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;

                case '/':
                    i++;
                    stack.push(c);
                    break;

                case '*':
                    i++;
                    if(stack.empty() || stack.pop() != '/')
                        return false;
            }
        }

        return stack.empty();
    }
}
