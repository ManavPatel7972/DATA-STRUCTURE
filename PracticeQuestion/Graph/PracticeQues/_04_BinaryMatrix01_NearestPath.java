package PracticeQues;

import java.util.LinkedList;
import java.util.Queue;

public class _04_BinaryMatrix01_NearestPath {

    public static class Node{
        int first;
        int second;
        int third;

        Node(int first,int second,int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }

    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Node(i,j,0));
                }
                else {
                    vis[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().third;
            q.remove();
            dis[row][col] = step;

            // Up
            if (row - 1 >= 0 && vis[row - 1][col] == 0) {
                vis[row - 1][col] = 1;
                q.add(new Node(row - 1, col, step + 1));
            }
            // Down
            if (row + 1 < n && vis[row + 1][col] == 0) {
                vis[row + 1][col] = 1;
                q.add(new Node(row + 1, col, step + 1));
            }
            // Left
            if (col - 1 >= 0 && vis[row][col - 1] == 0) {
                vis[row][col - 1] = 1;
                q.add(new Node(row, col - 1, step + 1));
            }
            // Right
            if (col + 1 < m && vis[row][col + 1] == 0) {
                vis[row][col + 1] = 1;
                q.add(new Node(row, col + 1, step + 1));
            }
        }
        return dis;
    }

    public static void main(String[] args) {

    }
}
