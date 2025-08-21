package BST;

public class ConstructAVL {
    public static class Node{
        int val;
        Node left;
        Node right;
        int height;

        Node(int val){
            this.val = val;
            height = 1;
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

    public static int height(Node root){
        if(root == null) return 0;
        return root.height;
    }

    public static int getBalance(Node root) {
        if(root == null) return 0;
        return height(root.left) - height(root.right);
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

        root.height = 1 +  Math.max(height(root.left),height(root.right));

        // Here Check After Insertion Node is balanced or Not
        int balance = getBalance(root);

        if(balance > 1){ //left heavy

            if(val < root.left.val){ //LL
                return rightRotate(root);
            }
            else { //LR
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if(balance < -1){ // right heavy

            if(val > root.right.val) { //RR
                return leftRotate(root);
            }
            else { //RL
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
    }

    //Right Rotation
    public static Node rightRotate(Node y){
        Node x = y.left;
        Node t2 = x.right;

        //rotation
        x.right = y;
        y.left = t2;

        //update The Height
        y.height = 1 + Math.max(height(y.left),height(y.right));
        x.height = 1 + Math.max(height(x.left),height(x.right));

        return x;
    }
    //Left Rotation
    public static Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;

        //rotation
        x.left = y;
        y.right = t2;

        //update The Height
        y.height = 1 + Math.max(height(y.left),height(y.right));
        x.height = 1 + Math.max(height(x.left),height(x.right));

        return x;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] tree = {0,1,2,3,4,5,6,7,8};
        for(int i=0;i<tree.length;i++){
            root = insert(root,tree[i]);
        }
        inorder(root);
        System.out.println();

        displayPretty(root,0);

    }
}
