package CloneListWithRandomPtr;

import java.util.*;

class Node {
    private int data;
    private Node next;
    private Node random;
    Node() {}
    Node(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public Node getRandom() {
        return random;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setRandom(Node random) {
        this.random = random;
    }
}
class List {
    private Node head;
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public void print() {
        Node temp = head;
        System.out.println("");
        while(temp != null) {
            System.out.print(temp.getData()+"->");
            temp = temp.getNext();
        }
        temp = head;
        System.out.println("\n--------------------------");
        while(temp != null) {
            if(temp.getRandom() != null)
                System.out.println(temp.getData() + "\'s random is " + temp.getRandom().getData());
            temp = temp.getNext();
        }
    }
    public void insert(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if(temp == null) {
            this.head = newNode;
        } else {
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    public void attachRandom(int position1, int position2) {
        Node n1 = head, n2 = head;
        while(position1 > 1 && n1 != null && n1.getNext() != null) {
            n1 = n1.getNext();
            position1--;
        }
        while(position2 > 1 && n2 != null && n2.getNext() != null) {
            n2 = n2.getNext();
            position2--;
        }
        n1.setRandom(n2);
    }
    public Node clone() {
        Node cloneHead = null, temp = head;
        while(temp != null) {
            Node clonedNode = new Node(temp.getData());
            clonedNode.setNext(temp.getNext());
            temp.setNext(clonedNode);
            temp = clonedNode.getNext();
        }
        temp = head;
        while(temp != null && temp.getNext() != null) {
            Node clone = temp.getNext();
            if(cloneHead == null) {
                cloneHead = clone;
            }
            if(temp.getRandom() != null) {
                clone.setRandom(temp.getRandom().getNext());
            }
            temp.setNext(clone.getNext());
            temp = clone.getNext();
            if(temp != null)
                clone.setNext(temp.getNext());
        }
        return cloneHead;
    }
}

class Main {
    public static void print(Node head) {
        Node temp = head;
        System.out.println("");
        while(temp != null) {
            System.out.print(temp.getData()+"->");
            temp = temp.getNext();
        }
        temp = head;
        System.out.println("\n--------------------------");
        while(temp != null) {
            if(temp.getRandom() != null)
                System.out.println(temp.getData() + "\'s random is " + temp.getRandom().getData());
            temp = temp.getNext();
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List list = new List();
            for(int i = 0; i < n ; i++) {
                list.insert(sc.nextInt());
            }
            /**
             * Tested with below i/p
             * 5
             * 10 5 20 15 2
             */
            list.attachRandom(1, 3);
            list.attachRandom(2, 4);
            list.attachRandom(3, 1);
            list.attachRandom(4, 3);
            list.attachRandom(5, 4);
            list.print();
            Node clone = list.clone();
            print(clone);
            list.print();
        }
    }
}