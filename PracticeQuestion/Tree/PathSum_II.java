package BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathSum_II {
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root = null;

    static Scanner sc = new Scanner(System.in);

    public static void createTree() {
        System.out.println("Enter a Root Node : ");
        int val = sc.nextInt();
        root = new TreeNode(val);
        createTree(sc, root);
    }

    private static void createTree(Scanner sc, TreeNode node) {
        System.out.println("left of " + node.val + " (Yes -> 1)(No -> 0)");
        int left = sc.nextInt();

        if (left == 1) {
            System.out.println("Enter the value of the left of " + node.val);
            int val = sc.nextInt();
            node.left = new TreeNode(val);
            createTree(sc, node.left);
        }

        System.out.println("right of " + node.val + " (Yes -> 1)(No -> 0)");
        int right = sc.nextInt();
        if (right == 1) {
            System.out.println("Enter the value of the right of " + node.val);
            int val = sc.nextInt();
            node.right = new TreeNode(val);
            createTree(sc, node.right);
        }
    }

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

    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static boolean pathSum_I(TreeNode root, int targetSum, int sum){
        if(root == null) return false;
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            return targetSum == sum;
        }
        boolean ls = pathSum_I(root.left,targetSum,sum);
        boolean rs = pathSum_I(root.right,targetSum,sum);
        return ls || rs;
    }

    public static void helper(TreeNode root,int targetSum , List<Integer> li){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(!pathSum_I(root,targetSum,0)){
                li.add(root.val);
                res.add(li);
            }
        }
        helper(root.left,targetSum,li);
        helper(root.right,targetSum,li);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> li = new ArrayList<>();
        helper(root,targetSum,li);
        return res;
    }

    public static void main(String[] args) {
        createTree();
        System.out.println();
        displayPretty(root, 1);
        System.out.println();
        System.out.println(pathSum(root,22));
    }

}


