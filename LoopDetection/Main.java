package LoopDetection;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    public static Boolean isLoopExisting(SLL list) {
        SLLNode slow = list.getHead(), fast = list.getHead();
        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            SLL list = new SLL();
            int n = sc.nextInt();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            SLLNode temp = list.getHead(), tail = null;
            while(temp != null) {
                if(temp.getNext() == null) 
                    tail = temp;
                temp = temp.getNext();
            }
            tail.setNext(list.getHead());
            System.out.println(isLoopExisting(list));
        }
    }
}