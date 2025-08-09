import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();
        int n = tokens.length;

        for(int i = 0; i < n; i++) {
            String s = tokens[i];

            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int v2 = val.pop();
                int v1 = val.pop();

                if(s.equals("+")) val.push(v1 + v2);
                else if(s.equals("-")) val.push(v1 - v2);
                else if(s.equals("*")) val.push(v1 * v2);
                else if(s.equals("/")) val.push(v1 / v2);
            } else {
                val.push(Integer.parseInt(s));
            }
        }

        return val.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
