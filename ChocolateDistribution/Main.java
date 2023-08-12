package ChocolateDistribution;

import java.util.*;

class Main {
    static int getChocolateDistribution(int[] arr, int m) {
        int ans = -1, n = arr.length;
        if(m <= n) {
            Arrays.sort(arr);
            ans = Integer.MAX_VALUE;
            for(int i = 0 ; i <= n - m ; i++) {
                ans = Math.min(ans, Math.abs(arr[i] - arr[i + m - 1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = getChocolateDistribution(arr, m);
            System.out.println("\nAnswer = " + ans);
        }
    }
}