class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}

public class RemoveDuplicates {

    public static Node removeDuplicates(Node head) {
        Node t1 = head;

        while (t1 != null) {

            Node t2 = t1;

            while (t2.next != null) {
                if (t2.next.val == t1.val) {
                   
                    t2.next = t2.next.next;

                } else {

                    t2 = t2.next;

                }
            }

            t1 = t1.next;
        }

        return head;
    }

   
    public static void display(Node head) {

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
       
    }
}
