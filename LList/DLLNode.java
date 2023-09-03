package LList;

public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode prev;
    
    DLLNode() {};
    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }
    public DLLNode getNext() {
        return next;
    }
    public DLLNode getPrev() {
        return prev;
    }
    public void setNext(DLLNode next) {
        this.next = next;
    }
    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }
    public void setData(int data) {
        this.data = data;
    }
}