package RemoveDupsFromSortedList;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    public static void removeDuplicates(SLL list) {
        SLLNode head = list.getHead();
        if(head != null && head.getNext() != null) {
            SLLNode temp = head.getNext(), valid = head;
            while(temp != null) {
                if(valid.getData() != temp.getData()) {
                    valid.getNext().setData(temp.getData());
                    valid = valid.getNext();
                }
                temp = temp.getNext();
            }
            valid.setNext(null);
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            SLL list = new SLL();
            int n = sc.nextInt();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            removeDuplicates(list);
            list.print();
        }
    }
}