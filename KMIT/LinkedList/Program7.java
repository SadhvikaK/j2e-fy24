class Program7{
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    private class Node {
        int value;
        Node prev;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    public Program7(int k) {
        this.size = 0;
        this.capacity = k;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.value;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        Program7 circularDeque = new Program7(3);
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }

}