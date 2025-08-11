public class ImplementQqUsingLinkedList {
    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    public static class Queue{
        Node f = null;
        Node r = null;
        int size = 0;

        public void add(int val){
            Node temp = new Node(val);
            if(f == null){
                f = r = temp;
            }
            else{
                r.next = temp;
                r = temp;
            }
            size++;
        }

        public int remove() throws Exception{
            if(f == null){
                throw new Exception("Queue Is Empty!!");
            }
            int x = f.val;
            f = f.next;
            size--;
            return x;
        }

        public int peek() throws Exception{
            if(f == null){
                throw new Exception("Queue Is Empty!!");
            }
            return f.val;
        }

        public boolean isEmpty(){
            if(size == 0) return true;
            return false;
        }

        public void display(){
            if(f == null){
                System.out.println("Queue Is Empty!!");
            }
            Node temp = f;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        
        Queue q = new Queue(); 
         q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.display();
        System.out.println(q.size);
        try{
            System.out.println(q.remove());
            System.out.println(q.peek());
        }catch(Exception e){
            e.getMessage();
        }
        
        System.out.println(q.size);
        q.display();

    }
}
