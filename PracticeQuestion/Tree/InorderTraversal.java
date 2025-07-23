package BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.val);
        } else {
            System.out.println(node.val);
        }
        displayPretty(node.left, level + 1);
    }

    public static void helper(TreeNode root, List<Integer> li) {
        if (root == null) return;

        helper(root.left, li);
        li.add(root.val);
        helper(root.right, li);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if (root != null) {
            helper(root, li);
        }
        return li;
    }


    public static void main(String[] args) {
        createTree();
        displayPretty(root, 0);
        System.out.print(inorderTraversal(root));

    }
}
