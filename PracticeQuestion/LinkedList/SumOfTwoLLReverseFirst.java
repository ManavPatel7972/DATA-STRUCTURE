public class SumOfTwoLLReverseFirst {

    public static class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;

        }
    }

    static Node head = null;

    public static Node createNode(int x){
        Node newNode = new  Node(x);
        return newNode;

    }
     
    public static void display(Node head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static Node sumOfLL(Node h1,Node h2){

        Node t1 = h1;
        Node t2 = h2;

        Node dummy = createNode(-1);
        Node curr = dummy;
        int carry = 0;
        


        while(t1!=null || t2!= null || carry!=0){

            int sum  = carry;

            if(t1!=null){
                sum = sum + t1.val;
                t1 = t1.next;
            }

            if(t2!=null){
                sum = sum + t2.val;
                t2 = t2.next;
            }

            carry = sum/10;
            Node newNode = createNode(sum%10);
            curr.next = newNode;
            curr = newNode;
        }

        return dummy.next;

    }

    public static Node addNumber(Node t1,Node t2){
       Node sumList =  reverse(sumOfLL(reverse(t1), reverse(t2)));
       return sumList;
    }


    public static void main(String[] args) {
        
    //    head =  createNode(10);
    //    head.next = createNode(20);
    //    head.next.next = createNode(30);
    //    head.next.next.next = createNode(40);
    //    head.next.next.next.next = createNode(50);

    Node h1 = createNode(7);
    h1.next = createNode(2);
    h1.next.next = createNode(4);
    h1.next.next.next = createNode(3);

    Node h2 = createNode(5);
    h2.next = createNode(6);
    h2.next.next = createNode(4);

    display(h1);

    display(h2);

    display(addNumber(h1, h2));


    }
}

