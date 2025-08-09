import java.util.Scanner;
import java.util.Stack;

public class BlancedBracateOrNot {

    public static boolean isBlancedBracet(String str) {

        Stack<Character> st = new Stack<>();

        int n = str.length();

        if (n == 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {

            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(ch);
            }

            else {
                if (st.isEmpty()) {
                    return false;
                }
                if (st.peek() == '(') {
                    st.pop();
                }
            }

            if (st.size() > 0) {
                return false;
            } else {
                return true;
            }
        }
        
        return false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter a String:");

        String str = "()(";

        System.out.println(isBlancedBracet(str));

    }

}
