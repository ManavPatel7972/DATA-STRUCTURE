
public class STRUCTURE_DLL {

    public static class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;

        }
    }

   static Node head = null;


    public static Node createNode(int x){
        Node newNode = new Node(x);  
        return newNode;
    }

    public static void display(Node head) {
        Node t = head;

        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }

        System.out.println();
    }



    
    public static void main(String[] args) {
        
        head = createNode(0);
        head.prev = null;
        head.next = createNode(2);
        head.next.prev = head;
        head.next.next = createNode(1);
        head.next.next.prev = head.next;
        head.next.next.next = createNode(0);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = createNode(1);
        head.next.next.next.next.prev = head.next.next.next;

        display(head);

    }
}
