package KthSmallestElement;

import java.util.*;

class Main {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], validIndex = low;
        for(int i = low ; i < high ; i++) {
            if(arr[i] < pivot) {
                swap(arr, i, validIndex);
                validIndex++;
            }
        }
        swap(arr, high, validIndex);
        return validIndex;
    }

    static int findKthHelper(int[] arr, int k, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            if(pivot == k - 1) return arr[pivot]; 
            if(pivot > k - 1) return findKthHelper(arr, k, low, pivot - 1);
            if(pivot < k - 1) return findKthHelper(arr, k, pivot + 1, high);
        }
        return -1;
    }

    static int findKthElement(int[] arr, int k) {
        int element = findKthHelper(arr, k, 0, arr.length - 1);
        return element;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = findKthElement(arr, k);
            System.out.println("\nans = " + ans);
        }
    }
}
