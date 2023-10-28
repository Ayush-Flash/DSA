package NextGreaterElement;

import java.util.*;

class Main {
    public static int[] getNextGreaterElements(int[] arr, int n) {
        int[] nextGreaterElements = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nextGreaterElements[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            nextGreaterElements[stack.pop()] = n + 1;
        }
        return nextGreaterElements;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int [] nextGreaterElements = getNextGreaterElements(arr, n);
            System.out.println("Next Greater Elements " + Arrays.toString(nextGreaterElements));
        }
    }
}