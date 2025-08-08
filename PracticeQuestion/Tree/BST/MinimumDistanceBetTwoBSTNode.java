package BST;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumDistanceBetTwoBSTNode {
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

    //METHOD -1;
    Integer prev = null;
    int min = Integer.MAX_VALUE;

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        inorder(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    //METHOD -2

    public static void inorder_M2(TreeNode root, List<Integer> li){
        if(root == null) return;
        inorder_M2(root.left,li);
        li.add(root.val);
        inorder_M2(root.right,li);
    }
    public static void helper(TreeNode root){

    }
    public int minDiffInBST_M2(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inorder_M2(root,li);
        int min = Integer.MAX_VALUE;

        for(int i=1;i<li.size();i++){
            min = Math.min(min,li.get(i) - li.get(i-1));
        }
        return min;
    }


    public static void main(String[] args) {
        createTree();
        System.out.println();
        displayPretty(root, 1);
    }

}



