package LList;

public class DLL {
    private DLLNode head;
    private int size;
    public DLLNode getHead() {
        return head;
    }
    public int getSize() {
        return size;
    }
    public Boolean isEmpty() {
        return this.head == null;
    }
    public void print() {
        DLLNode temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.print("NULL\n");
    }

    public DLLNode insertAtBegning(int data) {
        DLLNode newNode = new DLLNode(data);
        newNode.setNext(head);
        if(!isEmpty()) 
            head.setPrev(newNode);
        head = newNode;
        size++;
        return head;
    }

    public DLLNode insertAtEnd(int data) {
        if(isEmpty())
            return insertAtBegning(data);
        else {
            DLLNode newNode = new DLLNode(data);
            DLLNode temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
            size++;
            return head;
        }
    }

    public DLLNode insert(int data, int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1) 
            return insertAtBegning(data);
        else if(pos > size)
            return insertAtEnd(data);
        else {
            DLLNode temp = head;
            int count = 1;
            while(count < pos) {
                temp = temp.getNext();
                count++;
            }
            DLLNode newNode = new DLLNode(data);
            DLLNode prev = temp.getPrev();
            newNode.setPrev(prev);
            newNode.setNext(temp);
            prev.setNext(newNode);
            temp.setPrev(newNode);
            size++;
            return head;
        }
    }

    public DLLNode deleteFromBegning() {
        if(!isEmpty()) {
            head = head.getNext();
            size--;
        }
        return head;
    }

    public DLLNode deleteFromEnd() {
        if(size <= 1)
            return deleteFromBegning();
        else {
            DLLNode temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            DLLNode prev = temp.getPrev();
            prev.setNext(null);
            size--;
            return head;
        }
    }

    public DLLNode delete(int pos) {
        if(pos < 1) {
            System.out.println("Invalid value for the position");
            return head;
        }
        if(pos == 1) 
            return deleteFromBegning();
        else if(pos >= size)
            return deleteFromEnd();
        else {
            DLLNode temp = head;
            int count = 1;
            while(count < pos) {
                temp = temp.getNext();
                count++;
            }
            DLLNode prevNext = temp.getNext();
            DLLNode nextPrev = temp.getPrev();
            DLLNode prev = nextPrev, next = prevNext;
            prev.setNext(prevNext);
            next.setPrev(nextPrev);
            size--;
            return head;
        }
    }

    public DLLNode reverse() {
        if(size > 1) {
            DLLNode current = head.getNext();
            while(current != null) {
                DLLNode nextCurrent = current.getNext();
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