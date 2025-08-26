package BasicsOfGraph;
import java.util.*;

public class _07_DfsTraversalUsingAdjMatrix {
    // Directions: up, down, left, right
      static int[] delRow = {-1, 1, 0, 0};
      static int[] delCol = {0, 0, -1, 1};

    // DFS Function
    public static void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    !visited[newRow][newCol]) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        dfs(grid, visited, 0, 0);
    }
}
