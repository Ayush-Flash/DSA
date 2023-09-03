package SortedInsert;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    public static SLLNode sortedInsert(SLL list, int key) {
        SLLNode head = list.getHead();
        int counter = 1;
        while(head != null && head.getData() < key) {
            head = head.getNext();
            counter++;
        }
        return list.insert(key, counter);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            SLL list = new SLL();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            int key = sc.nextInt();
            list.print();
            sortedInsert(list, key);
            list.print();
        }
    }
}