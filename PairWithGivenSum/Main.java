package PairWithGivenSum;

import java.util.*;

class Main {
    static int[] getPairWithGivenSum(int[] arr, int target) {
        int[] ans = new int[2];
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++) {
            hs.add(arr[i]);
        }
        for(int i = 0 ; i < arr.length ; i++) {
            int key = target - arr[i];
            hs.remove(arr[i]);
            if(hs.contains(key)) {
                ans[0] = arr[i];
                ans[1] = key;
                return ans;
            }
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = getPairWithGivenSum(arr, target);
            System.out.println(Arrays.toString(ans));
        }
    }
}