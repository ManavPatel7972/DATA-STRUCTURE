import java.util.Stack;

public class Postfix_Evaluation {

    public static int potsfix_Evaluation(String str){
        
        String postfix = str;
        Stack<Integer> val = new Stack<>();

        for(int i=0;i<postfix.length();i++){

            char ch = postfix.charAt(i);
            int ascci = (int) ch;

            if(ascci>=48 && ascci<=57){
                val.push(ascci-48);
            }

            if(ch == '+' || ch=='-' || ch=='*' || ch=='/'){

                int v2 = val.pop();
                int v1 =  val.pop();
                
                if(ch == '+') val.push(v1+v2);
                if(ch == '-') val.push(v1-v2);
                if(ch == '*') val.push(v1*v2);
                if(ch == '/') val.push(v1/v2);
                
            }

        }

        return val.pop();


    }
    public static void main(String[] args) {

        String postfix = "953+4*6/-"; // 953+4*6/-

        System.out.println("Ans = " + potsfix_Evaluation(postfix));

    }
}
