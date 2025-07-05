import java.util.*;

public class PalindromeLL {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
        

    }

    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = arr.size()-1;

        while (l<r) {
            if(arr.get(l) != arr.get(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;

    }

    public static void main(String[] args) {

    }
}