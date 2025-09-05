package PracticeQues;
import java.util.*;
/*
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
vertices such that for every directed edge u-v, vertex u comes before v in the ordering.
Note: Topological Sorting for a graph is not possible if the graph is not a DAG.
 */

public class _09_TopologicalSort {

    public void dfs(int node,int[] vis , ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }
        st.push(node);
    }

    public int[] topologicalSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }

        int[] ans = new int[V];
        int i=0;
        while (!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
}
