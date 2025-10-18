package App;

public class List {
    private final String name;
    private Node head;
    private Node tail;
    private int length;

    public List() {
        this.name = "New List";
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public List(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void add(String value) {
        Node newNode = new Node(length + 1, value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
        }
    }

    public void remove(int index) {
        index -= 1; // shift to 0-based index
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return;
        }
        if (index == 0) {
            head = head.next;
            length--;
            return;
        }
        if (index == length - 1) {
            tail = tail.prev;
            length--;
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        currentNode.next.prev = currentNode;
        length--;
    }

    public void print() {
        Node currentNode = head;
        System.out.println("List: " + name);
        while (currentNode != null) {
            if (currentNode.done) {
                System.out.println(currentNode.index + ". [X] " + currentNode.value);
            } else {
                System.out.println(currentNode.index + ". [ ] " + currentNode.value);
            }
            currentNode = currentNode.next;
        }
    }

    public void markAsDone(int index) {
        index -= 1; // shift to 0-based index
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.done = true;
    }

    public void markAsNotDone(int index) {
        index -= 1; // shift to 0-based index
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.done = false;
    }
}

class Node {
    public int index;
    public String value;
    public Node next;
    public Node prev;
    public boolean done;

    public Node(int index, String value) {
        this.index = index;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}