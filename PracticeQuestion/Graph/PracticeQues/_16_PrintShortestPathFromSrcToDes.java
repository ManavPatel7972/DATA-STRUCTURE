package PracticeQues;

import java.util.*;

public class _16_PrintShortestPathFromSrcToDes {

    public static class AdjPair{
        int first;
        int second;

        AdjPair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static class QueuePair{
        int dis;
        int currentNode;

        QueuePair(int dis, int currentNode){
            this.dis = dis;
            this.currentNode = currentNode;
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges){
        ArrayList<ArrayList<AdjPair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<AdjPair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new AdjPair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new AdjPair(edges[i][0],edges[i][2]));
        }
        int[] distance = new int[n];
        int[] parent = new int[n];
        Queue<QueuePair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        distance[0] = 0;
        q.add(new QueuePair(0,0));

        while (!q.isEmpty()){
            int dis = q.peek().dis;
            int node = q.peek().currentNode;
            q.remove();

            for(int i=0;i<adj.get(node).size();i++){
                int adjNode = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dis + wt < distance[adjNode]){
                    distance[adjNode] = dis + wt;
                    q.add(new QueuePair(distance[adjNode],adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(distance[n-1] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }

        int node = n-1;
        while (parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(0);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {

    }

}
