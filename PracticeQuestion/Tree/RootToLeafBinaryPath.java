package BT;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafBinaryPath {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int height(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void helper(TreeNode root, List<String> li, String str) {

        if (root == null) return;
        if (root.left == null && root.right == null) {
            str += root.val;
            li.add(str);
        }

        helper(root.left, li, (str + root.val + "->"));
        helper(root.right, li, (str + root.val + "->"));

    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> li = new ArrayList<>();
        if (root != null) {
            helper(root, li, "");
        }
        return li;
    }

    public static void main(String[] args) {

    }

}