package PracticeQues;

import java.util.ArrayList;
import java.util.Stack;

public class _13_ShortestPathForAllNodeToSrc {

    public static class Pair{
        int first;
        int second;

        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }

        for(int i=0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                topoSort(i,adj,vis,st);
            }
        }

        int[] dis = new int[V];
        for(int i=0;i<V;i++){

            dis[i] = Integer.MAX_VALUE;
        }
        dis[0] = 0; // here src = 0 so dis[0] = 0 , general dis[src] = 0

        while (!st.isEmpty()){
            int node = st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dis[node] + wt < dis[v]){
                    dis[v] = dis[node] + wt;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }
    public static void main(String[] args) {

    }
}
