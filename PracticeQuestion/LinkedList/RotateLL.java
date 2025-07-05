

public class RotateLL {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    
    public static ListNode nThNode(ListNode head,int k){

        ListNode t = head;

        if(t == null || k==0){
            return t;
        }

        for(int i=1;i<k;i++){
            t = t.next;
        }

        return t;
    }

    public static ListNode rotateLL(ListNode head, int k) {

        if (head == null || k==0 ) {
            return null;
        }

        ListNode tail = head;
        int c = 1;

        while(tail.next!=null){
            c++;
            tail = tail.next;
        }

        if(k%c == 0){
            return head;
        }

        k = k % c;

        tail.next = head;
        ListNode lastKthNode = nThNode(head, c-k);
        
        head = lastKthNode.next;
        lastKthNode.next = null;
        
        return head;
    }

    public static int count(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void display(ListNode head){

        ListNode temp = head;

        if(head == null) return;

        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {





        // display(t2);
        
        // System.out.println();

        // t2 = rotateRight(t2,1);

        // System.out.println();

        // display(t2);
    }

}