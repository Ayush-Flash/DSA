package LargestAreaInAHistogram;

import java.util.*;

class Main {
    static int getLargestAreaInAHistogram(int[] arr, int n) {
        int area = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int currentTop = stack.pop();
                int currentArea = arr[currentTop] * (stack.isEmpty() ? i :(i - stack.peek() - 1));
                area = Math.max(area, currentArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int currentTop = stack.pop();
            area = Math.max(area, arr[currentTop] * (stack.isEmpty() ? n : (n - stack.peek() - 1)));
        }
        return area;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Largest Area In Given Histogram Is = " + getLargestAreaInAHistogram(arr, n));
        }
    }
}