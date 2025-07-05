import java.util.ArrayList;
import java.util.List;

public class SortLL {

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

    public static Node sortLL(Node head){

        List<Integer> a = new ArrayList<>();

        Node temp = head;

        while(temp != null){
            a.add(temp.val);
            temp = temp.next;
        }

        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                if(a.get(i)>a.get(j)){
                    int t = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, t);
                }
            }
        }

        Node dup = createNode(-10);
        dup.next = null;

        Node curr = dup;

        for(int i=0;i<a.size();i++){
           Node newNode = createNode(a.get(i));
            curr.next = newNode;
            curr = newNode; 
        }

        return dup.next;

        
    }

    public static void main(String[] args) {

       head =  createNode(10);
       head.next = createNode(17);
       head.next.next = createNode(7);
       head.next.next.next = createNode(9);
       head.next.next.next.next = createNode(50);
       head.next.next.next.next.next = createNode(1);


       display(head);

       head = sortLL(head);

       display(head);
        
    }
}
