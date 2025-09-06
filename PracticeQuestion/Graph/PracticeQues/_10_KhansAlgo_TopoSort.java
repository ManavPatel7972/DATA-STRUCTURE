package PracticeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _10_KhansAlgo_TopoSort {

    public int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] inDegree = new int[V];
        int[] vis = new int[V];

        // step -1 Count Indegree
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inDegree[i]++;
            }
        }

        // step -2 Indegree 0 So add Into the Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int i=0;
        while (!q.isEmpty()){
            int node = q.remove();
            topo[i++] = node;

            for(int j=0;i<adj.get(node).size();j++){
                inDegree[j]--;
                if(inDegree[j] == 0){
                    q.add(j);
                }
            }
        }
        return topo;
    }
}
