package PalindromeCheck;

import java.util.*;

class Node {
    private char data;
    private Node next;
    public Node() {}
    public Node(char data) {
        this.data = data;
        this.next = null;
    }
    public char getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setData(char data) {
        this.data = data;
    }
}

class List {
    private Node head;
    private char data;
    
    public Node getHead() {
        return head;
    }
    
    public char getData() {
        return data;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.print("NULL\n");
    }

    public Node insert(char data) {
        Node newNode = new Node(data);
        Node temp = head;
        while(temp != null && temp.getNext() != null) {
            temp = temp.getNext();
        }
        if(temp != null)
            temp.setNext(newNode);
        else 
            head = newNode;
        return head;
    }

    public Boolean isPalindrome() {
        Node slow = head, fast = head;
        if(head == null || head.getNext() == null) 
            return true;
        while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();            
        }
        Node current = slow.getNext(), prev = null, next = current.getNext();
        while(current != null) {
            current.setNext(prev);
            prev = current;
            current = next;
            if(next != null)
                next = next.getNext();
        }
        slow.setNext(prev);
        Node start = head, rev = slow.getNext();
        while(rev != null) {
            if(start.getData() != rev.getData()) return false;
            start = start.getNext();
            rev = rev.getNext();
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List list = new List();
            for(int i = 0 ; i < n ; i++) {
                list.insert(sc.next().charAt(0));
            } 
            System.out.println("Is Palindrome? = " + list.isPalindrome()); 
        }
    }
}