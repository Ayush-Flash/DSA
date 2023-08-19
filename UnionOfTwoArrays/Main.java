package UnionOfTwoArrays;

import java.util.*;

class Main {
    static ArrayList<Integer> getUnionOfTwoArrays(int[] arr, int[] brr) {
        int n1 = arr.length, n2 = brr.length;
        ArrayList<Integer> union = new ArrayList<>();
        HashSet<Integer> uniqueElements = new HashSet<>();
        for(int i = 0 ; i < n1 ; i++) {
            uniqueElements.add(arr[i]);
        }
        for(int i = 0 ; i < n2 ; i++) {
            uniqueElements.add(brr[i]);
        }
        for(int i = 0 ; i < n1 ; i++) {
            if(uniqueElements.contains(arr[i])) {
                union.add(arr[i]);
                uniqueElements.remove(arr[i]);
            }
        }
        for(int i = 0 ; i < n2 ; i++) {
            if(uniqueElements.contains(brr[i])) {
                union.add(brr[i]);
                uniqueElements.remove(brr[i]);
            }
        }
        return union;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            int[] arr = new int[n1];
            for(int i = 0 ; i < n1 ; i++) {
                arr[i] = sc.nextInt();
            }
            int[] brr = new int[n2];
            for(int i = 0 ; i < n2 ; i++) {
                brr[i] = sc.nextInt();
            }
            ArrayList<Integer> union = getUnionOfTwoArrays(arr, brr);
            System.out.println(union);
        }
    }
}