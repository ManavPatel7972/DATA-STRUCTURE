package BST;

public class ConstructBST {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            left = right = null;
        }
    }
    static Node root = null;

    public static void displayPretty(Node node, int level) {

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

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val<root.val){
            root.left = insert(root.left,val);
        }
        else if (val > root.val) {
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] tree = {50,30,70,20,40,60,80};
        for(int i=0;i<tree.length;i++){
            root = insert(root,tree[i]);
        }
        inorder(root);
        System.out.println();
        displayPretty(root,0);
    }
}
