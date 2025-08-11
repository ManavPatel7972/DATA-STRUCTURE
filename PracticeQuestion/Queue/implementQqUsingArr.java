public class implementQqUsingArr {
    public static class Queue {
        int[] arr = new int[5];
        int f = -1;
        int r = -1;
        int size = 0;

        public void add(int val) throws Exception {

            if (r > arr.length) {
                throw new Exception("Queue Is Full!!");
            }
            if (f == -1) {
                f = r = 0;
                arr[0] = val;
            } 
            else {
                arr[++r] = val;
            }
            size++;
        }

        public int remove() throws Exception {
            if (size == 0) {
                throw new Exception("Queue Is Empty!!");
            }
            size--;
            return arr[f++];
        }

        public int peek() throws Exception {
            if (size == 0) {
                throw new Exception("Queue Is Empty!!");
            }
            return arr[f];
        }

        public boolean isEmpty() {
            if (size == 0)
                return true;
            return false;
        }

        public void display() {
            for (int i = f; i <= r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        Queue q = new Queue();
        try{
            q.add(10);
            q.add(20);
            q.add(30);
            q.add(40);
            q.add(50);
            q.add(30);
            q.add(40);
            q.add(50);
            q.display();
            System.out.println(q.size);
            System.out.println(q.remove());
            System.out.println(q.peek());
            System.out.println(q.size);
        }catch(Exception e){
           e.getLocalizedMessage();
        }
        
    }
}
