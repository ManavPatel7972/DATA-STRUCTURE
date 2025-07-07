// package Stack;

import java.util.Stack;

public class ValidParenthisisOrNot {


    public static boolean validOrNot(String str){

        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++){

            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' ){
                st.push(str.charAt(i));
            }
            else{

                if(st.size() == 0){
                    return false;
                }
                
                if( st.peek()=='(' && str.charAt(i)==')' ||
                    st.peek()=='{' && str.charAt(i)=='}' ||
                    st.peek()=='[' && str.charAt(i)==']'
                ){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }

       if(st.size() == 0){
        return true;
       }

       return false;
    }
    public static void main(String[] args) {
        System.out.println(validOrNot("]"));

    }
}
