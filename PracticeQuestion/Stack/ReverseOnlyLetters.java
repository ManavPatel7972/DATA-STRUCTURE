package Stack;

import java.util.Stack;

public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                st.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                res.append(st.pop());

            } 
            else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        String input = "a-bC-dEf-ghIj";

        String output = reverseOnlyLetters(input);
        
        System.out.println("Reversed: " + output);
    }
}
