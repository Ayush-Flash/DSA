package StockSpanProblem;

import java.util.*;

class Main {

    public static int[] getStocksSpan(int[] stocks) {
        int n = stocks.length;
        int[] spans = new int[n];
        spans[0] = 1;
        ArrayDeque<Integer> previousGreaterElementsIdx = new ArrayDeque<>();
        previousGreaterElementsIdx.push(0); 
        for(int i = 1 ; i < n ; i++) {
            while(!previousGreaterElementsIdx.isEmpty() 
                && stocks[previousGreaterElementsIdx.peek()] <= stocks[i]) {
                    previousGreaterElementsIdx.pop();
            }
            int span = previousGreaterElementsIdx.isEmpty() ? i + 1 : i - previousGreaterElementsIdx.peek();
            previousGreaterElementsIdx.push(i);
            spans[i] = span;
        }
        return spans;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int[] spans = getStocksSpan(arr);
            System.out.println("Spans = " + Arrays.toString(spans));
        }
    }
}