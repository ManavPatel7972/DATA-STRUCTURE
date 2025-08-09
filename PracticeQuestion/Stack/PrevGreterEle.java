

import java.util.Stack;

public class PrevGreterEle {

    public static int[] prevGreter(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];

        st.push(arr[0]);
        res[0] = -1;

        for(int i=1;i<n;i++){
            while(st.size()>0 && st.peek()<arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                res[i] =  -1;
            }
            else{
                res[i] =  st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] res = prevGreter(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
