package FrequencyOfElements;

import java.util.*;

class Pair implements Comparable<Pair>{
    private int key;
    private int value;
    Pair(){}
    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
    public int compareTo(Pair next) {
        int res;
        res = this.value < next.value ? 1 : -1;
        if(this.value == next.value) {
            res = this.key > next.key ? 1 : -1;
        }
        return res;
    }
}

class Main {
    static ArrayList<Pair> getFrequency(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> elementToFrequency = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            if(elementToFrequency.containsKey(arr[i])) {
                elementToFrequency.put(arr[i], elementToFrequency.get(arr[i]) + 1);
            } else {
                elementToFrequency.put(arr[i], 1);
            }
        }
        ArrayList<Pair> pairs = new ArrayList<>();
        for(Integer key : elementToFrequency.keySet()) {
            pairs.add(new Pair(key, elementToFrequency.get(key)));
        }
        Collections.sort(pairs);
        return pairs;
    }

    static void printPairs(ArrayList<Pair> pairs) {
        System.out.print("[");
        Boolean showComma = false;
        for(Pair pair : pairs) {
            if(showComma) System.out.print(", ");
            System.out.print("{" + pair.getKey() + " => " + pair.getValue() + "}");
            showComma = true;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Pair> pairs = getFrequency(arr);
            printPairs(pairs);
        }
    }
}