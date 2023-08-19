package IntersectionOfTwoArrays;

import java.util.*;

class Main {

    static ArrayList<Integer> getIntersestion(int[] arr, int[] brr) {
        int n1 = arr.length, n2 = brr.length;
        ArrayList<Integer> intersection = new ArrayList<>();
        HashSet<Integer> brrElements = new HashSet<>();
        for(int i = 0 ; i < n2 ; i++) {
            brrElements.add(brr[i]);
        }
        for(int i = 0 ; i < n1 ; i++) {
            if(brrElements.contains(arr[i])) {
                intersection.add(arr[i]);
                brrElements.remove(arr[i]);
            }
        }
        return intersection;
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
            ArrayList<Integer> intersection = getIntersestion(arr, brr);
            System.out.println(intersection);
        }
    }
}