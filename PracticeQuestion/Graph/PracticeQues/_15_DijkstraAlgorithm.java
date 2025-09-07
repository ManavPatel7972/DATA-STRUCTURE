package PracticeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _15_DijkstraAlgorithm {

    public static class Pair{
        int first;
        int second;

        Pair(int first, int second){
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

    public int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj,int src){
        int[] distance = new int[V];

        for(int i=0;i<V;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<QueuePair> q = new LinkedList<>();
        distance[src] = 0;
        q.add(new QueuePair(0,src));

        while (!q.isEmpty()){
            int nodeDis = q.peek().dis;
            int node = q.peek().currentNode;
            q.remove();

            for(int i=0;i<adj.get(node).size();i++){

                int near = adj.get(node).get(i).first;
                int wt = adj.get(near).get(i).second;

                if(wt + nodeDis < distance[near]){
                    distance[near] = wt + nodeDis;
                    q.add(new QueuePair(distance[near],near));
                }
            }
        }

        //-1 for not reachable
        for(int i=0;i<V;i++){
            if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }

        return distance;
    }

    public static void main(String[] args) {

    }
}
