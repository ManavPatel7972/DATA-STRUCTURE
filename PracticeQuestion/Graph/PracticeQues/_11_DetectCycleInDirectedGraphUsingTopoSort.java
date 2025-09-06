package PracticeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11_DetectCycleInDirectedGraphUsingTopoSort {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];


        //step-1 find indegree of all node
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        //step-2 queue put all node in queue which indegrree is 0;
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int i=0;
        int count = 0;
        while (!q.isEmpty()){
            count++;
            int node = q.remove();
            topo[i++] = node;

            for(int j=0;j<adj.get(node).size();j++){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }

        }

        if(count == V) return false;
        return true;
    }


    public static void main(String[] args) {

    }
}
