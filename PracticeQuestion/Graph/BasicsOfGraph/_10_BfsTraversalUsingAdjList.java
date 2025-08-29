package BasicsOfGraph;

import java.util.*;

public class _10_BfsTraversalUsingAdjList {

    public static void bfsTraversal(ArrayList<ArrayList<Integer>> adjList, int startVertex) {
        int vertices = adjList.size();
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            ArrayList<Integer> neighbors = adjList.get(currentVertex);
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 1, 4);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 3, 5);
        addEdge(adjList, 4, 5);

        bfsTraversal(adjList, 0);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
