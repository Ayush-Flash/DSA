package ThreeWayPartition;

import java.util.*;

class Main {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void partitionAroundPivot(int[] arr, int a, int b) {
        int highIndex = arr.length - 1, smallIndex = 0;
        for(int i = 0 ; i <= highIndex; ) {
            if(arr[i] < a) {
                swap(arr, smallIndex++, i++);
            } else if(arr[i] > b) {
                swap(arr, highIndex--, i);
            } else {
                i++;
            }
        }
    }   

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int a = sc.nextInt(), b = sc.nextInt();
            partitionAroundPivot(arr, a, b);
            System.out.println("\nPartioned Array = " + Arrays.toString(arr));
        }
    }
}