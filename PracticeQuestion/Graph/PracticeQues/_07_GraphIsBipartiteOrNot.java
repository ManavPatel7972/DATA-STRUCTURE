package PracticeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _07_GraphIsBipartiteOrNot {


    //BFS METHOD-1
    public boolean bsf(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int j = 0; j < graph[node].length; j++) {
                int near = graph[node][j];
                if (color[near] == -1) {
                    color[near] = 1 - color[node];
                    q.add(near);
                } else if (color[near] == color[node]) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bsf(i, graph, color) == false) return false;
            }
        }
        return true;
    }


    //DFS METHOD-2
//    public boolean isBipartite2(int[][] graph) {
//        int n = graph.length;
//        int[] vis = new int[n];
//
//        for(int i=0;i<n;i++){
//            vis[i] = -1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (vis[i] == -1)
//                if (dfs(i, graph,vis, 0) == false) return false;
//        }
//        return true;
//    }
//
//    private boolean dfs(int start,int[][] graph, int[] vis, int color) {
//        vis[start] = color;
//
//        for (int adj : graph[start]) {
//            if (vis[adj] == -1) {
//                if (dfs(adj,graph,vis,1-color) == false) return false;
//            }
//            else if (color == vis[adj]) return false;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {

    }
}
