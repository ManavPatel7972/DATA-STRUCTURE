package LinkedList;
public class ImplementLinkedList {

}

class MyLinkedList {

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    int get(int index) {
        if (index < 0 || index >= size) {
            return -1;

        }

        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node temp = head;

        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = head;
        }

        size++;
    }

    void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        }

        else {
            Node nweNode = new Node(val);
            tail.next = nweNode;
            tail = tail.next;
            size++;
        }
    }

    void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        else if (index == 0) {
            addAtHead(val);
        }

        else if (index == size) {
            addAtTail(val);
        }

        else {

            Node temp = head;
            Node newNode = new Node(val);
            for (int i = 1; i <= index - 1; i++) {
                temp = temp.next;
            }

            // newNode.next = temp.next;
            // temp.next = newNode;
            // size++;

            Node prevNode = getNodeAtIndex(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        else if (size == 1) {
            head = null;
            tail = null;

        }

        else if (index == 0) {
            head = head.next;
        }

        else if (index == size - 1) {
            Node previousNode = getNodeAtIndex(index - 1);
            previousNode.next = null;
            tail = previousNode;
        }

        else {
            Node previousNode = getNodeAtIndex(index - 1);
            previousNode.next = previousNode.next.next;
        }
        size--;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}