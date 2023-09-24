package LRUCache;

import java.util.*;

import LList.DLLNode;

class Cache {
    private int size;
    private int capacity;
    private HashMap<Integer, DLLNode> elementsToAddress;
    private DLLNode mostRecentUseNode;
    private DLLNode leastRecentUseNode;
    public Cache() {}
    public Cache(int capacity) {
        this.capacity = capacity;
        elementsToAddress = new HashMap<>();
    }
    public void clearCache() {
        elementsToAddress = new HashMap<>();
        mostRecentUseNode = null;
        leastRecentUseNode = null;
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return capacity;
    }
    public HashMap<Integer, DLLNode> getElementsToAddress() {
        return elementsToAddress;
    }
    public DLLNode getMostRecentUseNode() {
        return mostRecentUseNode;
    }
    public DLLNode getLeastRecentUseNode() {
        return leastRecentUseNode;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setElementsToAddress(HashMap<Integer, DLLNode> elementsToAddress) {
        this.elementsToAddress = elementsToAddress;
    }
    public void setMostRecentUseNode(DLLNode mostRecentUseNode) {
        this.mostRecentUseNode = mostRecentUseNode;
    }
    public void setLeastRecentUseNode(DLLNode leastRecentUseNode) {
        this.leastRecentUseNode = leastRecentUseNode;
    }
    public void print() {
        DLLNode temp = mostRecentUseNode;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.print("NULL\n");
    }
    public void query(int data) {
        DLLNode nextMost;
        if(elementsToAddress.containsKey(data)) {
            nextMost = elementsToAddress.get(data);
            if(nextMost.getNext() == null) {
                leastRecentUseNode = nextMost.getPrev();
            }
            if(nextMost.getPrev() != null) {
                nextMost.getPrev().setNext(nextMost.getNext());
            }
            if(nextMost.getNext() != null) {
                nextMost.getNext().setPrev(nextMost.getPrev());
            }
        } else {
            if(size == capacity) {
                DLLNode nextLeast = leastRecentUseNode.getPrev();
                elementsToAddress.remove(leastRecentUseNode.getData());
                if(nextLeast != null) {
                    nextLeast.setNext(null);
                }
                leastRecentUseNode = nextLeast;
                size--;
            }
            nextMost = new DLLNode(data);
            if(size == 0) {
                leastRecentUseNode = nextMost;
                mostRecentUseNode = null;
            } 
            elementsToAddress.put(data, nextMost);
            size++;
        }
        nextMost.setPrev(null);
        nextMost.setNext(mostRecentUseNode);
        if(mostRecentUseNode != null)
            mostRecentUseNode.setPrev(nextMost);
        mostRecentUseNode = nextMost;
    }
}

class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(),capacity = sc.nextInt(), data;
            Cache lruCache = new Cache(capacity);
            while(n-->0) {
                data = sc.nextInt();
                lruCache.query(data);
                lruCache.print();
            }
        }
    }
}