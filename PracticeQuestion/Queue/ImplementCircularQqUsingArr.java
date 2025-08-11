public class ImplementCircularQqUsingArr {
    public static class CircularQueue{
        int[] arr = new int[5];
        int f = -1;
        int r = -1;
        int size = 0;

        public void add(int val){
            if(size >= arr.length){
                System.out.println("Queue Is Full");
                return;
            }
            else if(size == 0){
                f = r = 0;
                arr[0] = val;
            }
            else if(r == arr.length-1){
                arr[0] = val;
                r = 0;
            }
            else{
                arr[++r] = val;
            }
            size++;
        }

        public int remove(){
            if(size == 0){
                System.out.println("Queue Is Empty!!");
                return Integer.MIN_VALUE;
            }
            else if(f == arr.length -1){
                int x = arr[f];
                f = 0;
                size--;
                return x;
            }
            else{
                int x = arr[f];
                f++;
                size--;
                return x;
            }
        }

        public int peek(){
            if(size == 0){
                System.out.println("Queue Is Empty!!");
                return Integer.MIN_VALUE;
            }
            return arr[f];
        }

        public boolean isEmpty(){
            if(size == 0) return true;
            return false;
        }

        public void display(){
            if(size == 0){
                System.out.println("Queue Is Empty");
                return;
            }
            else if(f<r){
                for(int i=f;i<=r;i++){
                    System.out.print(arr[i] + " ");
                }
            }
            else{
                for(int i=f;i<=arr.length-1;i++){
                    System.out.print(arr[i] + " ");
                }
                for(int i=0;i<=r;i++){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5); 
        q.display();
        System.out.println("SIZE = " + q.size);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println("SIZE = " + q.size);
        q.add(100);
        System.out.println("SIZE = " + q.size);
        // q.add(200);
        q.remove();
        System.out.println("SIZE = " + q.size);
        q.add(200);
        
        q.display();
    }
}
