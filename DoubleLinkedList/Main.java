package DoubleLinkedList;

import java.util.*;

class Node {
    private int data;
    private Node next;
    private Node prev;
    
    Node() {};
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public void setData(int data) {
        this.data = data;
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
        if(!isEmpty()) 
            head.setPrev(newNode);
        head = newNode;
        size++;
        return head;
    }

    public Node insertAtEnd(int data) {
        if(isEmpty())
            return insertAtBegning(data);
        else {
            Node newNode = new Node(data);
            Node temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
            size++;
            return head;
        }
    }

    public Node insert(int data, int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1) 
            return insertAtBegning(data);
        else if(pos > size)
            return insertAtEnd(data);
        else {
            Node temp = head;
            int count = 1;
            while(count < pos) {
                temp = temp.getNext();
                count++;
            }
            Node newNode = new Node(data);
            Node prev = temp.getPrev();
            newNode.setPrev(prev);
            newNode.setNext(temp);
            prev.setNext(newNode);
            temp.setPrev(newNode);
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
        if(size <= 1)
            return deleteFromBegning();
        else {
            Node temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            Node prev = temp.getPrev();
            prev.setNext(null);
            size--;
            return head;
        }
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
            int count = 1;
            while(count < pos) {
                temp = temp.getNext();
                count++;
            }
            Node prevNext = temp.getNext();
            Node nextPrev = temp.getPrev();
            Node prev = nextPrev, next = prevNext;
            prev.setNext(prevNext);
            next.setPrev(nextPrev);
            size--;
            return head;
        }
    }

    public Node reverse() {
        if(size > 1) {
            Node current = head.getNext();
            while(current != null) {
                Node nextCurrent = current.getNext();
                current.setNext(current.getPrev());
                current.getPrev().setPrev(current);
                if(nextCurrent == null) {
                    head.setNext(null);
                    head = current;
                }
                current = nextCurrent;
            }
        }
        return head;
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