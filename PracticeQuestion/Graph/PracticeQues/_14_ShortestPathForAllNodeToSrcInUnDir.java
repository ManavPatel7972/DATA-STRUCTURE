package PracticeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an adjacency list, adj of Undirected Graph
 having unit weight of the edges, find the shortest path
  from src to all the vertex and if it is unreachable to reach any vertex,
   then return -1 for that vertex.

Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src=0
Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]
 */
public class _14_ShortestPathForAllNodeToSrcInUnDir {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {

        int[] dis = new int[adj.size()];
        for(int i=0;i<dis.length;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()){
            int node = q.remove();
            for(int it : adj.get(node)){
                if(dis[node] + 1 < dis[it]){
                    dis[it] = dis[node] + 1;
                    q.add(it);
                }

            }
        }

        for(int i=0;i<dis.length;i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }

    public static void main(String[] args) {

    }
}
