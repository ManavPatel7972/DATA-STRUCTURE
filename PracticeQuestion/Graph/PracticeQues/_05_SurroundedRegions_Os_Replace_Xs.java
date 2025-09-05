package PracticeQues;

public class _05_SurroundedRegions_Os_Replace_Xs {

    public void dfs(int row,int col,char[][] board,int[][] vis){

        vis[row][col] = 1;

        if(row-1>=0 && board[row-1][col] == 'O' && vis[row-1][col] == 0){
            dfs(row-1,col,board,vis);
        }

        if(row+1<board.length && board[row+1][col] == 'O' && vis[row+1][col] == 0){
            dfs(row+1,col,board,vis);
        }

        if(col-1>=0 && board[row][col-1] == 'O' && vis[row][col-1] == 0){
            dfs(row,col-1,board,vis);
        }

        if(col+1<board[0].length && board[row][col+1] == 'O' && vis[row][col+1] == 0){
            dfs(row,col+1,board,vis);
        }
    }
    public char[][] solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        char[][] res = new char[n][m];

        // First and last row
        for (int j=0;j<m;j++) {
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, board, vis);
            }
            if (board[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                dfs(n - 1, j, board, vis);
            }
        }

        // First and last column
        for (int i=0;i<n;i++) {
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, board, vis);
            }
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                dfs(i, m - 1, board, vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    res[i][j] = 'X';
                }
                else {
                    res[i][j] = 'O';
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
