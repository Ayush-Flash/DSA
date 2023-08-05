package BasicSorts;

import java.util.*;

class Main {

    static void print(int[] arr) {
        System.out.println("\n" + Arrays.toString(arr) + "\n" );
    }

    static void print(int[] arr, String s) {
        System.out.println("\n" + s + " = " + Arrays.toString(arr) + "\n");
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void merge(int[] arr, int low, int high, int mid) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0 ; i < n1 ; i++) {
            left[i] = arr[low + i];
        }

        for(int i = 0 ; i < n2 ; i++) {
            right[i] = arr[mid + i + 1];
        }

        int leftIndex = 0, rightIndex = 0, mergeIndex = low;
        while(leftIndex < n1 && rightIndex < n2) {
            if(left[leftIndex] <= right[rightIndex]) {
                arr[mergeIndex++] = left[leftIndex++];
            } else {
                arr[mergeIndex++] = right[rightIndex++];
            }
        }

        while(leftIndex < n1) {
            arr[mergeIndex++] = left[leftIndex++];
        }

        while(rightIndex < n2) {
            arr[mergeIndex++] = right[rightIndex++];
        }
    }

    static void mergeSortHelper(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSortHelper(arr, low, mid);
            mergeSortHelper(arr, mid + 1, high);
            merge(arr, low, high, mid);
        }
    }

    static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
        print(arr, "output");
    }

    static int partition(int[] arr, int low, int high) {
        int pivotElement = arr[high], validIndex = low;
        for(int i = low ; i < high ; i++) {
            if(arr[i] < pivotElement) {
                swap(arr, i, validIndex);
                validIndex++;
            }
        }
        swap(arr,validIndex, high);
        return validIndex;
    }

    static void quickSortHelper(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSortHelper(arr, low, pivot - 1);
            quickSortHelper(arr, pivot + 1, high);
        }
    }

    static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        print(arr, "output");
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1 ; i < n ; i++) {
            int j = i - 1, key = arr[i];
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        print(arr, "output");
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++) {
            int minIndex = i;
            for(int j = i + 1 ; j < n ; j++) {
                if(arr[j] < arr[minIndex]) {
                     minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        print(arr, "output");
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n - i - 1 ; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
        print(arr, "output");
    }

    public static void main(String[] args) {
       try(Scanner sc = new Scanner(System.in)) {
            System.out.println("");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            //bubbleSort(arr);
            //selectionSort(arr);
            //insertionSort(arr);
            //quickSort(arr);
            //mergeSort(arr);
       }
    }
}