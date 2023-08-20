package LongestSubarrayWithGivenSum;

import java.util.*;

class Main {
    static int[] subArrayWithGivenSum(int[] arr, int target) {
        int n = arr.length, currentSum = 0, maxLength = 0, startIndex = -1;
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            currentSum += arr[i];
            if(prefixSums.containsKey(currentSum - target)) {
                if(maxLength < i - prefixSums.get(currentSum - target)) {
                    startIndex = prefixSums.get(currentSum - target);
                    maxLength = i - startIndex;
                }
            } 
            if(!prefixSums.containsKey(currentSum)) {
                prefixSums.put(currentSum, i);
            }
        }
        int[] ans = new int[2];
        ans[0] = startIndex + 1;
        ans[1] = maxLength;
        return ans;
    
    }

    static void printLongestSubarrayWithGivenSum(int[] ans, int[] arr) {
        int counter = 0;
        int maxLength = ans[1], startIndex = ans[0];
        if(maxLength > 0) {
            while(counter < maxLength) {
                System.out.print(arr[startIndex + counter] + " ");
                counter++;
            }
            System.out.println("");
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(), target = sc.nextInt();;
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = subArrayWithGivenSum(arr, target);
            printLongestSubarrayWithGivenSum(ans, arr);
        }
    }
}