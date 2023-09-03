package MiddleOfList;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    /*
     * This function can use very simple approach
     * in which we can just call list.getSize();
     * and iterate list.getSize() / 2 times
     * and return middle Node, but assuming size var
     * is not maintained, following code is written
    */
    public static SLLNode getMiddleNode(SLL list) {
        SLLNode head = list.getHead();
        if(head == null || head.getNext() == null) {
            return head;
        } else {
            SLLNode slow = head, fast = head;
            while(fast != null && fast.getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }
            return slow;
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            SLL list = new SLL();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            SLLNode mid = getMiddleNode(list);
            System.out.println("Middle Node = " + mid.getData());
        }
    }
}