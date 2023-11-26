package InfixToPostFixAndEval;

import java.util.*;

class Main {

    public static int getPrecedence(Character c) {
        if(c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if( c == '+' || c == '-') {
            return 1;
        } else if(c == '(') {
            return 0;
        } else {
            return -1;
        }
    }

    public static String getPostFixExpression(String infix) {
        String postFix = "";
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : infix.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                postFix += c;
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    postFix += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(c)) {
                    postFix += stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            postFix += stack.pop();
        }
        return postFix;
    }

    public static double evalaue(String leftOperand, char operator,String rightOperand) {
        double d = -1;
        switch (operator) {
            case '+':
                d = Double.parseDouble(leftOperand) + Double.parseDouble(rightOperand);  
                break;
            case '-':
                d = Double.parseDouble(leftOperand) - Double.parseDouble(rightOperand);  
                break;
            case '*':
                d = Double.parseDouble(leftOperand) * Double.parseDouble(rightOperand);  
                break;
            case '/':
                d = Double.parseDouble(leftOperand) / Double.parseDouble(rightOperand);  
                break;
            case '^':
                d = Math.pow(Double.parseDouble(leftOperand), Double.parseDouble(rightOperand));  
                break;
        }
        return d;
    } 

    public static double evaluatePostFix(String postFix) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(char c : postFix.toCharArray()) {
            if(c >= '0' && c <= '9') {
                stack.push(c+"");
            } else {
                String rightOperand = stack.pop()+"";
                String leftOperand = stack.pop()+"";
                stack.push(String.valueOf(evalaue(leftOperand, c, rightOperand)));
            }
        }
        return Double.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            // String infix = sc.nextLine();
            // System.out.println(getPostFixExpression(infix));
            String postFix = sc.nextLine();
            System.out.println(evaluatePostFix(postFix));
        }
    }
}