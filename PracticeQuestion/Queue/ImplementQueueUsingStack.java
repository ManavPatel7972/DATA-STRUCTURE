
import java.util.*;

public class ImplementQueueUsingStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) {
            while (!st.isEmpty()) {
                stack.push(st.pop());
            }
        }
        return stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            while (!st.isEmpty()) {
                stack.push(st.pop());
            }
        }
        return stack.peek();
    }

    public boolean empty() {
        return st.isEmpty() && stack.isEmpty();
    }

    public static void main(String[] args) {
        
    }
}