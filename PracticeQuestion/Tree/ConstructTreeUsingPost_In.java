package BT;

public class ConstructTreeUsingPost_In {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode helper(int[] post, int ps, int pe, int[] in, int is, int ie) {

        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(post[pe]);

        int i = is;
        while (i <= ie && in[i] != post[pe]) {
            i++;
        }

        int leftSize = i - is;

        root.left = helper(post, ps, ps + leftSize - 1, in, is, i - 1);
        root.right = helper(post, ps + leftSize, pe - 1, in, i + 1, ie);
        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return helper(postorder, 0, n - 1, inorder, 0, n - 1);
    }

    public static void displayPretty(TreeNode node, int level) {
        if (node == null) return;
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

    public static void main(String[] args) {
        int[] postorder = {4, 5, 2, 6, 3, 1};
        int[] inorder = {4, 2, 5, 1, 3, 6};

        TreeNode root = buildTree(postorder, inorder);

        displayPretty(root, 0);
    }
}

