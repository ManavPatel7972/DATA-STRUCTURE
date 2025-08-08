package BST;

import java.util.Scanner;

public class Validate_BST {
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

 /*
     THIS APPROACH IS WRONG NOT COMPARE ALL TREE ONLY COMPARE NEXT ELEMENT SO WRONG

    public static boolean helper1(TreeNode root) {
        if (root == null) return true;
        if(root.left == null && root.right == null) return true;

        if(root.left != null){
            if (root.val <= root.left.val) {
                return false;
            }
        }
        if(root.right != null){
            if (root.val >= root.right.val) {
                return false;
            }
        }
        return helper1(root.left) && helper1(root.right);
    }

    public static boolean h1(TreeNode root){
        if(root == null) return true;
        if(root.left == null) return true;
        int x =  root.val;
        int y = root.left.val;
        if(x <= y) return false;
        return h1(root.left);
    }
    public static boolean h2(TreeNode root){
        if(root == null) return true;
        if(root.right == null) return true;
        int x =  root.val;
        int y = root.right.val;
        if(x >= y) return false;
        return h1(root.right);
    }
  */


    public static boolean helper(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if(root.left == null && root.right == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // here in this case -> [-2147483648,null,2147483647]  not use Integer MIN or MAX because
        // range is excited so use Long
    }

    public static void main(String[] args) {
        createTree();
        System.out.println();
        display(root);
        System.out.println();
        System.out.println("Ans = " + isValidBST(root));

    }

}


