

public class ReverseDLL_Using_TwoPointer {

    public static class Node{
        int val;
        Node rPtr;
        Node lPtr;

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
            t = t.rPtr;
        }

        System.out.println();
    }

    public static Node reverseDLL(Node head){

        Node prev = null;
        Node curr = head;

        if(head == null || head.rPtr == null){
            return head;
        }

        while(curr!=null){

            prev = curr.lPtr;
            curr.lPtr = curr.rPtr;
            curr.rPtr = prev;
            curr = curr.lPtr; 

        }

        return prev.lPtr;

    }
    
    public static void main(String[] args) {
        
        head = createNode(10);
        head.lPtr = null;
        head.rPtr = createNode(20);
        head.rPtr.lPtr = head;
        head.rPtr.rPtr = createNode(30);
        head.rPtr.rPtr.lPtr = head.rPtr;
        head.rPtr.rPtr.rPtr = createNode(40);
        head.rPtr.rPtr.rPtr.lPtr = head.rPtr.rPtr;
        head.rPtr.rPtr.rPtr.rPtr = createNode(50);
        head.rPtr.rPtr.rPtr.rPtr.lPtr = head.rPtr.rPtr.rPtr;

        display(head);

        System.out.println("After....");

        display(reverseDLL(head));

        display(head);
    }
}
