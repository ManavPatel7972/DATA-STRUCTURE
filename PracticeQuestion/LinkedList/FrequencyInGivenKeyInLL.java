public class FrequencyInGivenKeyInLL {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;

        }
    }

    static Node head = null;

    public static Node createNode(int x) {
        Node newNode = new Node(x);
        return newNode;

    }

    public static void display(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int count(Node head) {
        if (head == null) {
            return -1;
        }

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static int frequencyOfKey(Node head,int key){

        Node t = head;
        int c = 0;

        while(t!=null){
            
            if(t.val == key){
                c++;
            }
            t = t.next;
        }

        return c;
    }

    public static void main(String[] args) {

        head = createNode(1);
        head.next = createNode(2);
        head.next.next = createNode(1);
        head.next.next.next = createNode(2);
        head.next.next.next.next = createNode(1);
        head.next.next.next.next.next = createNode(3);
        head.next.next.next.next.next.next = createNode(1);

        display(head);

        System.out.println("Count = " + frequencyOfKey(head, 1));
    }
}
