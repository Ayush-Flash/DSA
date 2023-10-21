package BalancedParanthesis;

import java.util.*;

class Main {

    public static Boolean isBalanced(String paranthesisString) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> closeToOpenBracket = new HashMap<>();
        closeToOpenBracket.put(')', '(');
        closeToOpenBracket.put('}', '{');
        closeToOpenBracket.put(']', '[');
        for(int i = 0 ; i < paranthesisString.length() ; i++) {
            Character bracket = paranthesisString.charAt(i);
            Character top = stack.peek();
            if(bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if(top == closeToOpenBracket.get(bracket)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String paranthesisString = sc.nextLine();
            System.out.println("Balanced = " + isBalanced(paranthesisString));
        }
    }
}