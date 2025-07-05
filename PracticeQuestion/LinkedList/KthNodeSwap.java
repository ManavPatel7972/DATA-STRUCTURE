import java.util.ArrayList;
import java.util.List;

public class KthNodeSwap {

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

    public static void display(Node head){
        if(head == null){
            return;
        }

        Node temp = head;
        
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int count(Node head){
        if(head == null){
            return -1;
        }

        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
       return count;
    }

    public static Node swapNode(Node head,int k){

        Node t = head;


        List<Node> a = new ArrayList<>();

        while(t != null){
            a.add(t);
            t = t.next;
        }

        Node temp = a.get(k-1);
        a.set(k-1, a.get(a.size()-k));
        a.set(a.size()-k, temp);


        Node dup = createNode(-10);
        dup.next = null;

        Node curr = dup;

        for(int i=0;i<a.size();i++){
            Node newNode = createNode(a.get(i).val);
            curr.next = newNode;
            curr = newNode; 
        }

        return dup.next;
    }


    public static void main(String[] args) {

       head =  createNode(10);
       head.next = createNode(20);
       head.next.next = createNode(30);
       head.next.next.next = createNode(40);
       head.next.next.next.next = createNode(50);

       display(head);

     head = swapNode(head, 2);

      display(head);

        
    }
}
