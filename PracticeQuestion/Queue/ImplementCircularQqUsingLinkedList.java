public class ImplementCircularQqUsingLinkedList {
    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    public static class CircularQueue{
        Node f = null;
        Node r = null;
        int size = 0;

        public void add(int val){
            Node temp = new Node(val);
            if(f == null){
                f = r = temp;
                r.next = f;
            }
            else{
                r.next = temp;
                r = temp;
                r.next = f;
            } 
            size++;
        }

        public int remove(){
            if(f == null){
                System.out.println("Queue Is Empty!!");
                return -1;
            }
            else{
              int x = f.val;
              f = f.next;
              size--;
              r.next = f;
              return x;
            }
        }

        public int peek(){
            if(f == null){
                System.out.println("Queue Is Empty!!");
                return -1;
            }
            else{
                return f.val;
            }
        }

        public boolean isEmpty(){
            if(f == null) return true;
            return false;
        }

        public void display(){
            if(f == null){
                System.out.println("Queue is Empty!!");
                return;
            }
            Node temp = f;
            do{
                System.out.print(temp.val + " ");
                temp = temp.next;
            }while(temp!=f);

            System.out.println();
        }

    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.display();
        System.out.println("SIZE  = " + q.size);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println("SIZE  = " + q.size);
        q.display();
        System.out.println(q.r.next.val);
    }


}
