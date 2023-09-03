package NthNodeFromEnd;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    /**
     * Following function is wriiten based on assumption 
     * that we dont have size variable maintained
     */
    public static SLLNode getNthNodeFromEnd(SLL list, int n) {
        SLLNode head = list.getHead();
        if(head == null) return head;
        SLLNode fast = head;
        int counter = 1;
        while(fast != null && counter < n) {
            fast = fast.getNext();
            counter++;
        }
        SLLNode slow = head;
        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            SLL list = new SLL();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            int nth = sc.nextInt();
            SLLNode nthNode = getNthNodeFromEnd(list, nth);
            System.out.println("Node = " + nthNode.getData());
        }
    }
}