package ReverseInGroup;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    public static SLLNode reverseListInGroupOfK(SLL list, int k) {
        SLLNode head = list.getHead();
        SLLNode current = head, prev = null;
        int counter = k;
        while(counter > 0 && current != null) {
            SLLNode next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            counter--;
        }
        SLLNode finalHead = prev;

        while(current != null) {
            SLLNode nextHead = current;
            prev = null;
            counter = k;
            while(counter > 0 && current != null) {
                SLLNode next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
                counter--;
            }
            head.setNext(prev);
            head = nextHead;
        }
        list.setHead(finalHead);
        return finalHead;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            SLL list = new SLL();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            int k = sc.nextInt();
            reverseListInGroupOfK(list, k);
            list.print();
        }
    }
}