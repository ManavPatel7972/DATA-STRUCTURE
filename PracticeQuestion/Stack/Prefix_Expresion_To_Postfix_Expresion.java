import java.util.Stack;

public class Prefix_Expresion_To_Postfix_Expresion {

    public static String prefixExpreToPostfixExpre(String str) {

        String prefix = str;
        String postfix = "";

        Stack<String> val = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {

            char ch = prefix.charAt(i);

            int ascci = (int) ch;

            if (ascci >= 48 && ascci <= 57) {
                String s = "";
                s += ascci - 48;
                val.push(s);
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                String v1 = val.pop();
                String v2 = val.pop();
                char o = ch;

                postfix = v1 + v2 + o;

                val.push(postfix);

            }
        }
        
        return postfix;

    }

    public static void main(String[] args) {

        String prefix = "-9/*+5346";

        System.out.println("Prefix " + prefix + " To Postfix " + prefixExpreToPostfixExpre(prefix));

    }
}