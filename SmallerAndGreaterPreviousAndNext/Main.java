package SmallerAndGreaterPreviousAndNext;

import java.util.*;

class Main {
    public static void getNextAndPreviousSmaller(int[] arr, int n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];
        previousSmaller[0] = nextSmaller[n - 1] = -1;
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int focusIndex = stack.pop();
                nextSmaller[focusIndex] = arr[i];
                previousSmaller[focusIndex] = stack.isEmpty() ? -1 : arr[stack.peek()];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int focusIndex = stack.pop();
            nextSmaller[focusIndex] = -1;
            previousSmaller[focusIndex] = stack.isEmpty() ? -1 : arr[stack.peek()];
        }
        stack.clear();
        System.out.println("Previous Smaller Elements = " + Arrays.toString(previousSmaller));
        System.out.println("Next Smaller Elements = " + Arrays.toString(nextSmaller));
    }
    
    public static void getNextAndPreviousGreater(int[] arr, int n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] previousGreater = new int[n];
        int[] nextGreater = new int[n];
        previousGreater[0] = nextGreater[n - 1] = -1;
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int focusIndex = stack.pop();
                nextGreater[focusIndex] = arr[i];
                previousGreater[focusIndex] = stack.isEmpty() ? -1 : arr[stack.peek()];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int focusIndex = stack.pop();
            nextGreater[focusIndex] = -1;
            previousGreater[focusIndex] = stack.isEmpty() ? -1 : arr[stack.peek()];
        }
        stack.clear();
        System.out.println("Previous Greater Elements = " + Arrays.toString(previousGreater));
        System.out.println("Next Greater Elements = " + Arrays.toString(nextGreater));
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            getNextAndPreviousSmaller(arr, n);
            getNextAndPreviousGreater(arr, n);
        }
    }
}