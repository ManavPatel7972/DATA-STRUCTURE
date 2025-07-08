

// public class DesignWithIncrement {
   
// }

public class CustomStack{

    int maxSize = 0;
    
        public CustomStack(int maxSize){
            this.maxSize = maxSize;
        }

    int [] st = new int[maxSize];
    int idx = 0;

    public void push(int x) {
        
        if(st.length == idx){
            return;
        }

       else{
            st[idx] = x;
            idx++;
        }
    }

     public int pop() {
        if(idx == 0){
            return -1;
        }
        int x = st[idx -1];
        idx--;
        return x;
    }

     public void increment(int k, int val) {
        
        if(k<idx){
            for(int i=0;i<k;i++){
                st[i] += val;
            }
        }
        else{
             for(int i=0;i<idx;i++){
                st[i] += val;
            }
        }
    }


}
