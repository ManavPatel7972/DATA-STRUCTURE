package PracticeQues;

import java.util.*;

public class _01_NumberOfProvinces{

    public static void matrixToList(int[][] isConnected,List<List<Integer>> adj){
        int n = isConnected.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            for(int j=1;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
    }

    public static void dfs(int node, int[] vis, List<List<Integer>> adj){
        vis[node] = 1;
        for(int i = 0; i < adj.get(node).size(); i++) {
            int near = adj.get(node).get(i);
            if(vis[near] == 0) {
                dfs(near, vis, adj);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        matrixToList(isConnected,adj);
        int[] vis = new int[n];
        int count = 0;

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,vis,adj);
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
