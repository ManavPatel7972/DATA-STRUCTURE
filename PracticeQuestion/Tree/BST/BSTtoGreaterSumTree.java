package BST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class BSTtoGreaterSumTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(){}
    }

    static TreeNode root = null;

    static Scanner sc = new Scanner(System.in);

    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        display(node.left);
        display(node.right);
    }

    public static void displayPretty(TreeNode node, int level) {

        if (node == null) {
            return;
        }
        displayPretty(node.right, level + 1);

        if (level != 0) {

            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------->" + node.val);
        } else {
            System.out.println(node.val);
        }
        displayPretty(node.left, level + 1);
    }

    public void reverseInorder(TreeNode root, int[] sum) {
        if (root == null) return;
        reverseInorder(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        reverseInorder(root.left, sum);
    }

    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        reverseInorder(root, sum);
        return root;
    }




    public static void main(String[] args) {

    }

}



