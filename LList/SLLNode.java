package LList;

class SLLNode {
    private int data;
    private SLLNode next;
    SLLNode() {}
    SLLNode(int data) {
        this.data = data;
        this.next = null;
    }
    public int getData() {
        return data;
    }
    public SLLNode getNext() {
        return next;
    }
    public void setNext(SLLNode next) {
        this.next = next;
    }
    public void setData(int data) {
        this.data = data;
    }
}