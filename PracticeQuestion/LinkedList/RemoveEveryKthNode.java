
public class RemoveEveryKthNode {

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

    public static Node removeEveryKth(Node head,int k){

        Node t = head;
        Node prev = null;
        int count = 0;

        if(head == null || k<0){
            return null;
        }

        while(t!=null){
            
            count++;

            if(count%k == 0){

                if(prev !=null){
                    prev.next = t.next;
                }
                else{   // For 1 Size and K is First Node value
                    head = t.next;
                }
            }
            else{
                prev = t;
            }

            t = t.next;
        }

        return head;

    }

    public static void main(String[] args) {

        head = createNode(1);
        head.next = createNode(2);
        head.next.next = createNode(3);
        head.next.next.next = createNode(4);
        head.next.next.next.next = createNode(5);
        head.next.next.next.next.next = createNode(6);

        display(head);

        display(removeEveryKth(head, 3));

    }

}