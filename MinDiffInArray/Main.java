package MinDiffInArray;

import java.util.*;

class Main {

    static int getMinDiff(int[] arr) {
        if(arr.length >= 2) {
            int ans = Integer.MAX_VALUE, n = arr.length;
            Arrays.sort(arr);
            for(int i = 1 ; i < n ; i++) {
                ans = Math.min(ans, Math.abs(arr[i - 1] - arr[i]));
            }
            return ans;
        }
        return Integer.MIN_VALUE;
    }


    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = getMinDiff(arr);
            System.out.println("");
            System.out.println("Min Diff = " + ans);
        }
    }
}