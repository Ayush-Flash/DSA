package CountDistinctElements;

import java.util.*;

class Main {
    static int getCountOfUniqueElements(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++) {
            hs.add(arr[i]);
        }
        return hs.size();
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int count = getCountOfUniqueElements(arr);
            System.out.println("Unique count of elements = " + count);
        }
    }
}