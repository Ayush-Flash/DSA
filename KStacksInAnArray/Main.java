package KStacksInAnArray;

import java.util.*;

class KStacks {
    private int capacity;
    private int freeTop;
    private int k;
    private int[] tops;
    private int[] nextFreeTops;
    private int[] stack;

    public KStacks() {}
    public KStacks(int capacity, int k) {
        this.capacity = capacity;
        this.k = k;
        tops = new int[this.k];
        nextFreeTops = new int[this.capacity];
        stack = new int[this.capacity];
        freeTop = 0;
        for(int i = 0 ; i < k ; i++) 
            tops[i] = -1;
        for(int i = 0 ; i < capacity - 1 ; i++)
            nextFreeTops[i] = i + 1;
        nextFreeTops[capacity - 1] = -1;
    }

    public int push(int element, int k) {
        if(freeTop >= 0) {
            int currentFreeTop = freeTop;
            freeTop = nextFreeTops[currentFreeTop];
            nextFreeTops[currentFreeTop] = tops[k - 1];
            tops[k - 1] = currentFreeTop;
            stack[currentFreeTop] = element;
            return element;
        } else {
            System.out.println("Stack Over Flow");
            return Integer.MIN_VALUE;
        }
    }

    public int pop(int k) {
        if(tops[k - 1] >= 0) {
            int currentTop = tops[k - 1];
            tops[k - 1] = nextFreeTops[currentTop];
            nextFreeTops[currentTop] = freeTop;
            freeTop = currentTop;
            int poppedElement = stack[currentTop];
            stack[currentTop] = -1;
            return poppedElement;
        } else {
            System.out.println("Stack Under Flow");
            return Integer.MIN_VALUE;
        }
    }

    public Boolean isEmpty(int k) {
        return tops[k - 1] == -1;
    }
    public void print() {
        System.out.println(Arrays.toString(this.stack));
    }
}


class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            KStacks ks = new KStacks(6, 3);
            ks.push(1, 1);
            ks.push(1, 1);
            ks.push(2, 2);
            ks.push(2, 2);
            ks.push(3, 3);
            ks.push(3, 3);
            ks.print();
            ks.pop(1);
            ks.pop(2);
            ks.pop(1);
            ks.pop(3);
            ks.pop(1);
            ks.print();
            ks.push(7,3);
            ks.push(8, 3);
            ks.push(9, 3);
            ks.push(10, 3);
            ks.print();
            ks.push(11, 3);
        }
    }
}