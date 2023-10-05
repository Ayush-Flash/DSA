package Stack;

import java.util.*;

public class Stack {
    private ArrayList<Integer> stack;
    private int capacity;
    private int top;
    public ArrayList<Integer> getStack() {
        return stack;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getTop() {
        return top;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public void setStack(ArrayList<Integer> stack) {
        this.stack = stack;
    }
    public int getSize() {
        return stack == null ? 0 : stack.size();
    }
    public Boolean isEmpty() {
        return stack == null || stack.isEmpty();
    }
    public Stack() {
        stack = new ArrayList<>(capacity);
        capacity = 0;
        top = -1;
    }
    public Stack(int capacity) {
        stack = new ArrayList<>();
        top = -1;
        this.capacity = capacity;
    }
    public void print() {
        System.out.println(stack);
    }
    public void push(int data) {
        if(top < capacity - 1) {
            stack.add(++top, data);
        }
    }
    public int pop() {
        if(top >= 0) {
            int element = stack.get(top);
            stack.remove(top--);
            return element;
        } else {
            return -1;
        }
    }
    public int peek() {
        if(top >= 0) {
            int element = stack.get(top);
            return element;
        } else {
            return -1;
        }
    }
}