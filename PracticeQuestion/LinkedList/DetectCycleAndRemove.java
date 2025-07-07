public class DetectCycleAndRemove {

    public static class Node {
        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    static Node head = null;

     public static Node createNode(int x){
        Node newNode = new  Node(x);
        return newNode;

    }

    public static void display(Node head){
        if(head == null){
            return;
        }

        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static Node detectCycleRemove(Node head){
        if(head == null){
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next !=null){

            if(slow == fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null || fast.next == null){
            return head;
        }

        slow = head;
        Node prev = fast;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;

        return head;
    }
    public static void main(String[] args) {
       head =  createNode(10);
       head.next = createNode(20);
       head.next.next = createNode(30);
       head.next.next.next = createNode(40);
    // head.next.next.next.next = createNode(50);

       display(head);
        head = detectCycleRemove(head);
       display(head);

    }
}
