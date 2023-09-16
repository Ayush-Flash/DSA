package IntersectionOfTwoList;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    public static SLLNode incrementByDiff(SLL list, int diff) {
        SLLNode temp = list.getHead();
        while(diff > 1) {
            temp = temp.getNext();
            diff--;
        }
        return temp;
    }
    public static SLLNode getIntersection(SLL list1, SLL list2) {
        int length1 = 0;
        int length2 = 0;
        SLLNode l1 = list1.getHead(), l2 = list2.getHead();
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                l1 = l1.getNext();
                length1++;
            }
            if(l2 != null) {
                l2 = l2.getNext();
                length2++;
            }
        }
        int diff = Math.abs(length1 - length2);
        SLLNode ptr1 = null, ptr2 = null;
        if(length1 > length2) {
            ptr1 = incrementByDiff(list1, diff);
            ptr1 = ptr1.getNext();
            ptr2 = list2.getHead();
        } else {
            ptr2 = incrementByDiff(list2, diff);
            ptr2 = ptr2.getNext();
            ptr1 = list1.getHead();
        }
        while(ptr1 != null && ptr2 != null) {
            if(ptr1 == ptr2) {
                return ptr1;
            }
            ptr1 = ptr1.getNext();
            ptr2 = ptr2.getNext();
        }
        return null;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n1 = sc.nextInt();
            SLL list1 = new SLL();
            SLLNode connect = null;
            for(int i = 0 ; i < n1 ; i++) {
                list1.insertAtEnd(sc.nextInt());
            }
            int n2 = sc.nextInt();
            SLL list2 = new SLL();
            for(int i = 0 ; i < n2 ; i++) {
                list2.insertAtEnd(sc.nextInt());
            }
            connect = incrementByDiff(list1, 3);
            incrementByDiff(list2, n2).setNext(connect);
            SLLNode intersection = getIntersection(list1, list2);
            if(intersection != null) {
                System.out.println("Intersection " + intersection.getData());
            } else {
                System.out.println("No Intersection Found");
            }
        }
    }
}