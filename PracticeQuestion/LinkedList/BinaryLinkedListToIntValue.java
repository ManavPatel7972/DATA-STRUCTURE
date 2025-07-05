public class BinaryLinkedListToIntValue {
    
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public static int binaryToDecimal(int bin) {

        int dec = 0;
        int power = 0;

        while (bin > 0) {

            int ld = bin % 10;

            dec = dec + (int)(ld * Math.pow(2, power));
            power++;
            bin = bin / 10;
        }
        return dec;
    }

    public int getDecimalValue(ListNode head) {

        ListNode temp = head;

        String str = "";

        while(temp!=null){
            str+=temp.val;
            temp = temp.next;
        }

        int bin = Integer.parseInt(str);

        int n = binaryToDecimal(bin);

        return n;
     }



    public static void main(String[] args){
        
    }
}
