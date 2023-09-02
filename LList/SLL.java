package LList;

public class SLL {
    private SLLNode head;
    private int size;
    public SLLNode getHead() {
        return head;
    }
    public int getSize() {
        return size;
    }
    public Boolean isEmpty() {
        return this.head == null;
    }
    public void print() {
        SLLNode temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.print("NULL\n");
    }

    public SLLNode insertAtBegning(int data) {
        SLLNode newNode = new SLLNode(data);
        newNode.setNext(head);
        head = newNode;
        size++;
        return head;
    }

    public SLLNode insertAtEnd(int data) {
        if(isEmpty()) 
            return insertAtBegning(data);
        SLLNode temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        SLLNode newNode = new SLLNode(data);
        temp.setNext(newNode);
        size++;
        return head;
    }

    public SLLNode insert(int data, int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1)
            return insertAtBegning(data);
        else if (pos > size)
            return insertAtEnd(data);
        else  {
            SLLNode newNode = new SLLNode(data);
            SLLNode temp = head, newNodeNext = null;
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

    public SLLNode deleteFromBegning() {
        if(!isEmpty()) {
            head = head.getNext();
            size--;
        }
        return head;
    }

    public SLLNode deleteFromEnd() {
        if(size <= 1) return deleteFromBegning();
        SLLNode temp = head;
        while(temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        size--;
        return head;
    }

    public SLLNode delete(int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1)
            return deleteFromBegning();
        else if(pos >= size)
            return deleteFromEnd();
        else {
            SLLNode temp = head;
            int count = 1, index = pos - 1;
            while(count < index) {
                temp = temp.getNext();
                count++;
            }
            SLLNode newNext = temp.getNext().getNext();
            temp.setNext(newNext);
            size--;
            return head;
        }
    }

    public SLLNode reverse() {
        if(isEmpty()) 
            return head;
        else {
            SLLNode current = head;
            SLLNode next = current.getNext();
            while(next != null) {
                SLLNode nextLink = next.getNext();
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