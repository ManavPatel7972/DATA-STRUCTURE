package PracticeQues;

public class _02_NumberOfIsLand {

    public void dfs(int i, int j, char[][] grid, int[][] vis){
        vis[i][j] = 1;

        if(i+1 < grid.length && vis[i+1][j] == 0 && grid[i+1][j] == '1'){
            dfs(i+1, j, grid, vis);
        }
        if(i-1 >= 0 && vis[i-1][j] == 0 && grid[i-1][j] == '1'){
            dfs(i-1, j, grid, vis);
        }
        if(j+1 < grid[0].length && vis[i][j+1] == 0 && grid[i][j+1] == '1'){
            dfs(i, j+1, grid, vis);
        }
        if(j-1 >= 0 && vis[i][j-1] == 0 && grid[i][j-1] == '1'){
            dfs(i, j-1, grid, vis);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
