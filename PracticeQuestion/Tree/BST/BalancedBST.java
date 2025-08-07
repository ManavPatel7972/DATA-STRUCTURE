package BST;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedBST {
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

    public static void sortInorder(TreeNode root, List<TreeNode> li){
        if(root == null) return;
        sortInorder(root.left,li);
        li.add(root);
        sortInorder(root.right,li);
    }
    public static TreeNode createBST(List<TreeNode> li ,int start,int end){
        if(start>end) return null;
        int mid = (start + end)/2;
        TreeNode root = li.get(mid);
        root.left = createBST(li,start,mid-1);
        root.right = createBST(li,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> li = new ArrayList<>();
        sortInorder(root,li);
        return createBST(li,0,li.size()-1);
    }

    public static void main(String[] args) {
        createTree();
        System.out.println();
        displayPretty(root, 1);
    }

}


