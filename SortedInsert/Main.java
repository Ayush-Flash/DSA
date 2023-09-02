package SortedInsert;

import java.util.*;
import LList.SLL;

class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            SLL list = new SLL();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            list.print();
        }
    }
}