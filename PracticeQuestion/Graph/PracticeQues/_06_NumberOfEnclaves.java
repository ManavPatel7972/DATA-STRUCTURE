package PracticeQues;

public class _06_NumberOfEnclaves {


    // This Question also Solve Using the BSF algo....

    public void dfs(int row, int col, int[][] grid, int[][] vis) {
        vis[row][col] = 1;

//        Method - 1
//        int[] dr = {-1, 1, 0, 0}; // up, down
//        int[] dc = {0, 0, -1, 1}; // left, right
//
//        for (int i = 0; i < 4; i++) {
//            int nrow = row + dr[i];
//            int ncol = col + dc[i];
//
//            if (nrow >= 0 && nrow < grid.length && ncol >= 0 &&
//                    ncol < grid[0].length && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
//                dfs(nrow, ncol, grid, vis);
//            }
//        }


//        Method - 2
        if(row-1>=0 && grid[row-1][col] == 1 && vis[row-1][col] == 0){
            dfs(row-1,col,grid,vis);
        }

        if(row+1<grid.length && grid[row+1][col] == 1 && vis[row+1][col] == 0){
            dfs(row+1,col,grid,vis);
        }

        if(col-1>=0 && grid[row][col-1] == 1 && vis[row][col-1] == 0){
            dfs(row,col-1,grid,vis);
        }

        if(col+1<grid[0].length && grid[row][col+1] == 1 && vis[row][col+1] == 0){
            dfs(row,col+1,grid,vis);
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            // First column
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, grid, vis);
            }
            // Last column
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                dfs(i, m - 1, grid, vis);
            }
        }

        for (int j = 0; j < m; j++) {
            // First row
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                dfs(0, j, grid, vis);
            }
            // Last row
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                dfs(n - 1, j, grid, vis);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

    }
}
