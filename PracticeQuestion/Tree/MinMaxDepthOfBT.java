package BT;

import java.util.Scanner;

public class MinMaxDepthOfBT {
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

    public static void createTree(){
        System.out.println("Enter a Root TreeNode : ");
        int val = sc.nextInt();
        root = new TreeNode(val);
        createTree(sc,root);
    }

    private static void createTree(Scanner sc,TreeNode node){
        System.out.println("left of " + node.val + " (Yes -> 1)(No -> 0)");
        int left = sc.nextInt();

        if(left==1){
            System.out.println("Enter the value of the left of " + node.val);
            int val = sc.nextInt();
            node.left = new TreeNode(val);
            createTree(sc,node.left);
        }

        System.out.println("right of " + node.val + " (Yes -> 1)(No -> 0)");
        int right = sc.nextInt();
        if(right==1){
            System.out.println("Enter the value of the right of " + node.val);
            int val = sc.nextInt();
            node.right = new TreeNode(val);
            createTree(sc,node.right);
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
    public static void displayPretty(TreeNode node,int level){

        if(node == null){
            return;
        }
        displayPretty(node.right,level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t");
            }
            System.out.println("|------->" + node.val);
        }
        else{
            System.out.println(node.val);
        }
        displayPretty(node.left,level+1);
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }

    public static  int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public static void main(String[] args) {
        createTree();
        System.out.println("Min Height = " + minDepth(root));
        System.out.println("Max Height = " + maxDepth(root));
    }
}






