package BST;
import java.util.List;
import java.util.Scanner;

public class Construct_BSTFromPreOrder {
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

    public static void display(TreeNode root,List<Integer> li) {
        if (root == null) return;
        display(root.left,li);
        li.add(root.val);
        display(root.right,li);
    }

    public static void displayPretty(TreeNode node, int level) {
        if (node == null) return;

        displayPretty(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) System.out.print("|\t");
            System.out.println("|------->" + node.val);
        } else {
            System.out.println(node.val);
        }

        displayPretty(node.left, level + 1);
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);

        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {

        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++){
            root = insert(root,preorder[i]);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        root = bstFromPreorder(preorder);
    }
}





