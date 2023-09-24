package MergeTwoSortedList;

import java.util.*;
import LList.SLLNode;
import LList.SLL;

class Main {
    public static SLL merge(SLL list1, SLL list2) {
        SLL mergedSll = new SLL();
        if(list1 == null && list2 == null) {
            return mergedSll;
        } else if(list1 == null) {
            mergedSll.setHead(list2.getHead());
            return mergedSll;
        } else if(list2 == null) {
            mergedSll.setHead(list1.getHead());
            return mergedSll;
        }
        SLLNode ptr1 = list1.getHead(), ptr2 = list2.getHead();
        SLLNode merged = null, end = null;
        while(ptr1 != null && ptr2 != null) {
            if(ptr1.getData() < ptr2.getData()) {
                if(merged != null) {
                    SLLNode newNode = new SLLNode(ptr1.getData());
                    end.setNext(newNode);
                    end = newNode;
                } else {
                    merged = new SLLNode(ptr1.getData());
                    end = merged;
                }
                ptr1 = ptr1.getNext();
            } else {
                if(merged != null) {
                    SLLNode newNode = new SLLNode(ptr2.getData());
                    end.setNext(newNode);
                    end = newNode;
                } else {
                    merged = new SLLNode(ptr2.getData());
                    end = merged;
                }
                ptr2 = ptr2.getNext();
            }
        }
        while(ptr1 != null) {
            SLLNode newNode = new SLLNode(ptr1.getData());
            end.setNext(newNode);
            end = newNode;
            ptr1 = ptr1.getNext();
        }
        while(ptr2 != null) {
            SLLNode newNode = new SLLNode(ptr2.getData());
            end.setNext(newNode);
            end = newNode;
            ptr2 = ptr2.getNext();
        }
        mergedSll.setHead(merged);
        return mergedSll;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            SLL list1 = new SLL(), list2 = new SLL();
            for(int i = 0 ; i < n1 ; i++) {
                list1.insertAtEnd(sc.nextInt());
            }
            for(int i = 0 ; i < n2 ; i++) {
                list2.insertAtEnd(sc.nextInt());
            }
            SLL merged = merge(list1, list2);
            merged.print();
        }
    }
}