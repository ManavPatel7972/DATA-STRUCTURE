package PracticeQues;

import java.util.Arrays;

public class _03_FloodFill_Algorithm {

    public void dfs(int row, int col, int[][] image, int color, int originalColor) {
        int n = image.length;
        int m = image[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != originalColor) {
            return;
        }

        image[row][col] = color;

        dfs(row - 1, col, image, color, originalColor);
        dfs(row + 1, col, image, color, originalColor);
        dfs(row, col - 1, image, color, originalColor);
        dfs(row, col + 1, image, color, originalColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }
        dfs(sr, sc, image, color, originalColor);
        return image;
    }


    public static void main(String[] args) {

    }
}
