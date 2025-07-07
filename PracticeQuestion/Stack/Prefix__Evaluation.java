import java.util.Stack;

public class Prefix__Evaluation {

    public static int prefix_Evaluation(String str) {
        String prefix = str;

        Stack<Integer> val = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {

            char ch = prefix.charAt(i);
            int ascci = (int) ch;

            if (ascci >= 48 && ascci <= 57) {
                val.push(ascci - 48);
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Here Loop Revese chale and value pan val.pop() = v1 thase and pacchi ni v2
                // thase and pachhi v1 Operation v2 karvanu;

                int v1 = val.pop();
                int v2 = val.pop();

                if (ch == '+')
                    val.push(v1 + v2);
                if (ch == '-')
                    val.push(v1 - v2);
                if (ch == '*')
                    val.push(v1 * v2);
                if (ch == '/')
                    val.push(v1 / v2);
            }

        }
        
        return val.pop();
    }

    public static void main(String[] args) {
        String prefix = "-9/*+5346"; // -9/*+5346

        System.out.println("Ans = " + prefix_Evaluation(prefix));
    }
}
