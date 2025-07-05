public class StringSub_Remove {

    public static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        String s1 = "darshan";
        String s2 = "ash";

        Node head = null, tail = null;

        int i = 0;

        while (i < s1.length()) {
            Node newNode = new Node(s1.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            i++;
        }


        Node dummy = new Node('\0');
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        while (curr != null) {

            int j = 0;
            boolean found = false;

            
            while (j < s2.length()) {
                if (curr.data == s2.charAt(j)) {
                    found = true;
                    break;
                }
                j++;
            }

            if (found) {
               
                prev.next = curr.next;
            } else {

                prev = curr;
            }

            curr = curr.next;
        }
        
        Node temp = dummy.next;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

}