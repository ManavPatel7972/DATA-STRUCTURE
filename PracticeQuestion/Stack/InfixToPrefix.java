import java.util.Stack;

public class InfixToPrefix {

    public static String infixtoPrefix(String str) {

        String infix = str; // (A+B)*(C-D)
        String prefix = "";

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0;i<infix.length();i++){
            
            char ch = infix.charAt(i);
            int ascci = (int) ch;

            // Have jo apde (A+B)*(C-D) ani prefix jove to
            // pela ascci of A=65 and ascci of Z=90 in range badavavi khali ;

            
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

                    prefix = o + v1 + v2;
                    val.push(prefix);

                }

                op.pop();
            }

            else{

                if(ch=='+' || ch=='-'){
                    //work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    prefix = o + v1 + v2;
                    val.push(prefix);

                    op.push(ch);
                }
                if(ch=='*' || ch=='/'){
                    if(op.peek() == '*' || op.peek()=='/'){
                        //work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();

                        prefix = o + v1 + v2;
                        val.push(prefix);

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

            prefix = o + v1 + v2;
            val.push(prefix);
        }

        return prefix;
    }

    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";  //(A+B)*(C-D)  ->  *+AB-CD  

        System.out.println("Prefix = " + infixtoPrefix(infix));
    }
}
 