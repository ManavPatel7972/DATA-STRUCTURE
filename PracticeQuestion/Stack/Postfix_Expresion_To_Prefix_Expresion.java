import java.util.Stack;

public class Postfix_Expresion_To_Prefix_Expresion {

    public static String postfixExpreToPrefixExpre(String str) {

        String postfix = str;
        String prefix = "";

        Stack<String> val = new Stack<>();

        for (int i =0 ;i<postfix.length();i++) {

            char ch = postfix.charAt(i);

            int ascci = (int) ch;

            if (ascci >= 48 && ascci <= 57) {
                String s = "" ;
                s += ascci - 48;
                val.push(s);
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                String v2 = val.pop();
                String v1 = val.pop();
                char o = ch;

                prefix = o + v1 + v2;

                val.push(prefix);

            }
        }
        
        return prefix;

    }

    public static void main(String[] args) {

        String postfix = "953+4*6/-";  //Ans = -9/*+5346

        System.out.println("Postfix " + postfix + " To Prefix " + postfixExpreToPrefixExpre(postfix));
    }
}
