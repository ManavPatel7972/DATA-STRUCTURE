
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreterEle {

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
    
    public static int count(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }    

    public int[] nextLargerNodes(ListNode head) {

        Stack<Integer> st = new Stack();
        List<Integer> li = new ArrayList<>();

        int n = count(head);
        int[] res = new int[n];
        ListNode temp = head;

        while(temp != null){
            li.add(temp.val);
            temp = temp.next;
        }

        st.push(li.getLast());
        res[n-1] = 0;

        for(int i=li.size()-2;i>=0;i--){

            while(st.size()>0 && st.peek()<=li.get(i)){
                st.pop();
            }

            if(st.size()==0){
                res[i] = 0;
            }
            else{
                res[i] = st.peek();
            }

            st.push(li.get(i));
        }

        return res;

    }
}