package SortNegativesAndPositives;

import java.util.*;

class Main {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortNegativesAndPositives(int[] arr) {
        int n = arr.length, validIndex = 0;
        for(int i = 0 ; i < n - 1 ; i++) {
            if(arr[i] < 0) {
                swap(arr, validIndex, i);
                validIndex++;
            }
        } 
        swap(arr, n - 1, validIndex);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            sortNegativesAndPositives(arr);
            System.out.println("\n Sorted Array = " + Arrays.toString(arr));
        }
    }
}