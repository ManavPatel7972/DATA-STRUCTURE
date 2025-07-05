import java.util.Stack;

public class ReverseDLL_Using_Stack {

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

    public static Node reverseDLL(Node head){

        Stack<Integer> st = new Stack<>();

        Node t = head;

        while (t!=null) {
            st.push(t.val);
            t = t.next;
        }

        t = head;

        while (t!=null && st.size()>0) {
            t.val = st.pop();
            t = t.next;
        }

        return head;

    }



    
    public static void main(String[] args) {
        
        head = createNode(10);
        head.prev = null;
        head.next = createNode(20);
        head.next.prev = head;
        head.next.next = createNode(30);
        head.next.next.prev = head.next;
        head.next.next.next = createNode(40);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = createNode(50);
        head.next.next.next.next.prev = head.next.next.next;

        display(head);

        System.out.println("After....");

        display(reverseDLL(head));

    }
}
