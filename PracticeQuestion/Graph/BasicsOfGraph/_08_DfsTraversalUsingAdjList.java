package BasicsOfGraph;
import java.util.*;
public class _08_DfsTraversalUsingAdjList {

    public static void dfs(int node, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < adjList.get(node).size(); i++) {
            int neighbor = adjList.get(node).get(i);
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList);
            }
        }

    }

    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();
        int vertices = 6;

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).addAll(Arrays.asList(1, 2));
        adjList.get(1).addAll(Arrays.asList(0, 3));
        adjList.get(2).addAll(Arrays.asList(0, 4));
        adjList.get(3).addAll(Arrays.asList(1));
        adjList.get(4).addAll(Arrays.asList(2, 5));
        adjList.get(5).addAll(Arrays.asList(4));

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, adjList);
            }
        }
    }
}
