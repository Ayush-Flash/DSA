package StackUsingLL;

class Node {
    private int data;
    private Node next;
    private Node prev;
    public Node() {}
    public Node(int data) {
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

public class StackUsingLL {
    private int capacity;
    private Node top;
    private int size;
    public int getCapacity() {
        return capacity;
    }
    public int getSize() {
        return size;
    }
    public Node getTop() {
        return top;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setTop(Node top) {
        this.top = top;
    }
    public StackUsingLL(){}
    public StackUsingLL(int capacity){
        this.capacity = capacity;
    }
    public Node push(int data) {
        if(size < capacity) {
            Node newNode = new Node(data);
            newNode.setPrev(top);
            if(top != null) {
                top.setNext(newNode);
            }
            top = newNode;
            size++;
            return top;
        } else {
            return null;
        }
    }
    public Node pop() {
        if(top != null) {
            top = top.getPrev();
            if(top != null) {
                top.setNext(null);
            }
            size--;
        }
        return top;
    }
    public int peek() {
        if(top != null) {
            return top.getData(); 
        }
        return -1;
    }

    public void print() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.getData() + " <- ");
            temp = temp.getPrev();
        }
        System.out.print("NULL\n");
    }
}