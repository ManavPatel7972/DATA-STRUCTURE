import java.util.Stack;

public class infixToPostfix {

    public static String infixtoPostfix(String str) {

        String infix = str;
        String postfix = "";

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0;i<infix.length();i++){
            
            char ch = infix.charAt(i);
            int ascci = (int) ch;

            if(ascci>=48 && ascci<=57){
                String c = "" + ch;
                val.push(c);
            }

            else if(op.size() == 0 || ch=='(' || op.peek() == '('){
                op.push(ch);
            }

            else if(ch==')'){
                while(op.peek()!='('){
                    //work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    postfix = v1 + v2 + o;
                    val.push(postfix);

                }

                op.pop();
            }

            else{

                if(ch=='+' || ch=='-'){
                    //work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    postfix = v1 + v2 + o;
                    val.push(postfix);

                    op.push(ch);
                }
                if(ch=='*' || ch=='/'){
                    if(op.peek() == '*' || op.peek()=='/'){
                        //work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();

                        postfix = v1 + v2 + o;
                        val.push(postfix);

                        op.push(ch);
                    }
                    else{
                        op.push(ch);
                    }
                }
            }

        }

        while(val.size()>1){
            //work
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();

            postfix = v1 + v2 + o;
            val.push(postfix);
        }

        return postfix;
    }

    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";

        System.out.println("PostFix = " + infixtoPostfix(infix));
    }
}
 