package SegregateEvenOddNodes;

import java.util.*;
import LList.SLL;
import LList.SLLNode;

class Main {
    public static SLLNode segerateNodes(SLL list) {
        SLLNode temp = list.getHead();
        SLLNode evenEnd = null, evenHead = null, oddEnd = null, oddHead = null;
        while(temp != null) {
            SLLNode nextTemp = temp.getNext();
            temp.setNext(null);
            if(temp.getData() % 2 == 0) {
                if(evenHead == null) {
                    evenHead = temp;
                } else {
                    evenEnd.setNext(temp);
                }
                evenEnd = temp;
            } else {
                if(oddHead == null) {
                    oddHead = temp;
                } else {
                    oddEnd.setNext(temp);
                }
                oddEnd = temp;
            }
            temp = nextTemp;
        }
        if(evenEnd != null) {
            evenEnd.setNext(oddHead);
            list.setHead(evenHead);
        } else {
            list.setHead(oddHead);
        }
        return list.getHead();
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            SLL list = new SLL();
            for(int i = 0 ; i < n ; i++) {
                list.insertAtEnd(sc.nextInt());
            }
            segerateNodes(list);
            list.print();
        }
    }
}