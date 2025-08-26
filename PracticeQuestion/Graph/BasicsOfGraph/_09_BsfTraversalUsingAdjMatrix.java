package BasicsOfGraph;

import java.util.*;

public class _09_BsfTraversalUsingAdjMatrix {

    public static void bfs(int start, int[][] adjMatrix, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < adjMatrix[0].length; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;

        int[][] adjMatrix = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0}
        };

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                bfs(i, adjMatrix, visited);
            }
        }
    }
}
