package PreviousSmallerElement;

import java.util.*;

class Main {
    public static int[] getPreviousSmallerElements(int[] arr, int n) {
        int[] previousSmallerElements = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        previousSmallerElements[0] = -1;
        stack.push(0);
        for(int i = 1 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            previousSmallerElements[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return previousSmallerElements;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int[] previousSmallerElements = getPreviousSmallerElements(arr, n);
            System.out.println("Previous Smaller Elements = " + Arrays.toString(previousSmallerElements));
        }
    }
}