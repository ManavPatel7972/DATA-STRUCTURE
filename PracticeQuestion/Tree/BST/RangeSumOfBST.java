package BST;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RangeSumOfBST {
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

    //METHOD - 1
    public static void helper(TreeNode root, List<Integer> li){
        if(root == null) return;
        helper(root.left,li);
        li.add(root.val);
        helper(root.right,li);
    }
    public static int sumRange(List<Integer> li,int low,int high){
        int start = li.indexOf(low);
        int end = li.indexOf(high);
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum += li.get(i);
        }
        return sum;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> li = new ArrayList<>();
        helper(root,li);
       return sumRange(li,low,high);
    }

    //METHOD - 2
    static int sum = 0;
    public static void helper2(TreeNode root,int low,int high){
        if(root == null) return;
        if(root.val >= low && root.val<=high){
            sum += root.val;
        }
        helper2(root.left,low,high);
        helper2(root.right,low,high);
    }
    public int rangeSumBST2(TreeNode root, int low, int high) {
        return sum;
    }

    public static void main(String[] args) {
        createTree();
        System.out.println();
        displayPretty(root, 1);
    }

}


