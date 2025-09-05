package PracticeQues;

import java.util.ArrayList;

public class _08_DetectCycleInUndirectedGraph {


    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,int parent){
        vis[node] = 1;
        for(int near : adj.get(node)){
            if(vis[near] == 0){
                if(dfs(near,adj,vis,node) == true) return true;
            }
        }
        return false;
    }

    public boolean isCycle(){
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[V];

        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i,adj,vis,-1) == false) return false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {

    }
}
