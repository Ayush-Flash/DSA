package LargestRectangularAreaWithOnes;

import java.util.*;

class Main {
    public static int getMaxRectangularArea(int[] arr, int n) {
        int area = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int focusIndex = stack.pop();
                int nextSmallerIndex = i;
                int previousSmallerIndex = stack.isEmpty() ? -1 : stack.peek();
                int totalArea = previousSmallerIndex == -1 ? i : nextSmallerIndex - previousSmallerIndex - 1;
                area = Math.max(area, totalArea * arr[focusIndex]);
            }    
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int focusIndex = stack.pop();
            int previousSmallerIndex = stack.isEmpty() ? -1 : stack.peek();
            int totalArea = previousSmallerIndex == -1 ? n : n - previousSmallerIndex - 1;
            area = Math.max(area, arr[focusIndex] * totalArea);
        }
        return area;
    }

    public static int getMaxRectangularAreaWithOnes(int[][] grid, int n, int m) {
        int area = 0;
        int[] row = new int[m];
        for(int j = 0 ; j < m ; j++) {
            row[j] = 0;
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                row[j] += grid[i][j] == 0 ? -1 * row[j] : grid[i][j];
            }
            area = Math.max(area, getMaxRectangularArea(row, m));
        }
        return area;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] grid = new int[n][m];
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < m ; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println("Max Area With Ones = " + getMaxRectangularAreaWithOnes(grid, n, m));
        }
    }
}