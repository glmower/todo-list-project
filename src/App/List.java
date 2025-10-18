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
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove(int index) {
        index -= 1; // shift to 0-based index
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    public void print() {
        Node currentNode = head;
        System.out.println("List: " + name);
        while (currentNode != null) {
            System.out.println(currentNode.index + ". " + currentNode.value);
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