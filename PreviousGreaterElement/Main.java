package PreviousGreaterElement;

import java.util.*;

class Main {

    public static int[] getPreviousGreaterElements(int[] arr, int n) {
        int[] previousGreaterElements = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        previousGreaterElements[0] = -1;
        stack.push(0);
        for(int i = 1 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int element = stack.isEmpty() ? -1 : arr[stack.peek()];
            previousGreaterElements[i] = element;
            stack.push(i);
        }
        return previousGreaterElements;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int [] previousGreaterElements = getPreviousGreaterElements(arr, n);
            System.out.println("Previous Greater Elements " + Arrays.toString(previousGreaterElements));
        }
    }
}