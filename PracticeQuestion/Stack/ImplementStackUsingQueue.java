import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        int size = q.size();
        q.add(x);

        for(int i=0;i<size;i++){
            q.add(q.remove());
        }
    }
    public int pop() {
        return q.remove();
    }
    public int top() {
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        
    }
}



