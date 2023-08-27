package SinglyLinkedList;

import java.util.*;

class Node {
    private int data;
    private Node next;
    Node() {}
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head;
    private int size;
    public Node getHead() {
        return head;
    }
    public int getSize() {
        return size;
    }
    public Boolean isEmpty() {
        return this.head == null;
    }
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.print("NULL\n");
    }

    public Node insertAtBegning(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        size++;
        return head;
    }

    public Node insertAtEnd(int data) {
        if(isEmpty()) 
            return insertAtBegning(data);
        Node temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        Node newNode = new Node(data);
        temp.setNext(newNode);
        size++;
        return head;
    }

    public Node insert(int data, int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1)
            return insertAtBegning(data);
        else if (pos > size)
            return insertAtEnd(data);
        else  {
            Node newNode = new Node(data);
            Node temp = head, newNodeNext = null;
            int count = 1, index = pos - 1;
            while(count < index) {
                temp = temp.getNext();
                count++;
            }
            newNodeNext = temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(newNodeNext);
            size++;
            return head;
        }
    }

    public Node deleteFromBegning() {
        if(!isEmpty()) {
            head = head.getNext();
            size--;
        }
        return head;
    }

    public Node deleteFromEnd() {
        if(size <= 1) return deleteFromBegning();
        Node temp = head;
        while(temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        return head;
    }

    public Node delete(int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1)
            return deleteFromBegning();
        else if(pos >= size)
            return deleteFromEnd();
        else {
            Node temp = head;
            int count = 1, index = pos - 1;
            while(count < index) {
                temp = temp.getNext();
                count++;
            }
            Node newNext = temp.getNext().getNext();
            temp.setNext(newNext);
            size--;
            return head;
        }
    }

    public Node reverse() {
        if(isEmpty()) 
            return head;
        else {
            Node current = head;
            Node next = current.getNext();
            while(next != null) {
                Node nextLink = next.getNext();
                next.setNext(current);
                current = next;
                next = nextLink;
            }
            head.setNext(null);
            head = current;
            return head;
        }
    }
}

class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            LinkedList ls = new LinkedList();
            for(int i = 0 ; i < n ; i++) {
                ls.insert(sc.nextInt(), i + 1);
            }
            ls.print();
            // ls.insert(0, 1);
            // ls.print();
            // ls.insert(6, 6);
            // ls.print();
            // ls.insert(-1, 3);
            // ls.print();
            // ls.insert(11, 8);
            // ls.print();
            // ls.delete(1);
            // ls.print();
            // ls.delete(1);
            // ls.print();
            // ls.delete(8);
            // ls.print();
            // ls.delete(5);
            // ls.print();
            // ls.delete(3);
            // ls.print();
            // ls.reverse();
            // ls.print();
        }
    }
}