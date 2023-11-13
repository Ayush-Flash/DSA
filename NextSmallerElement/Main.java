package NextSmallerElement;

import java.util.*;

class Main {
    static int[] getNextSmallerElements(int[] arr, int n) {
        int[] nextSmallerElements = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                nextSmallerElements[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            nextSmallerElements[stack.pop()] = -1;
        }
        return nextSmallerElements;
    }
    //3 4 5 2 1
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int[] nextSmallerElements = getNextSmallerElements(arr, n);
            System.out.println("Next Smaller Elements = " + Arrays.toString(nextSmallerElements));
        }
    }
}