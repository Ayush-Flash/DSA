package StackWithGetMinInConstantTime;

import java.util.*;

class MinStack {
    private int min;
    private ArrayDeque<Integer> stack;

    public int getMin() {
        return min;
    }

    public ArrayDeque<Integer> getStack() {
        return stack;
    }
    
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new ArrayDeque<>();
    }

    public void push(int num) {
        if(num < min) {
            stack.push(2*num - min);
            min = num;
        } else {
            stack.push(num);
        }
    }

    public int pop() {
        int res = Integer.MAX_VALUE;
        if(!stack.isEmpty()) {
            int top = stack.pop();
            if(top < min) {
                res = min;
                min = 2*min - top; 
            } else {
                res = top;
            }
        }
        return res;
    }
}