package BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZigZagLevelOrderTraversal {
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
        System.out.println("Enter a Root Node : ");
        int val = sc.nextInt();
        root = new TreeNode(val);
        createTree(sc,root);
    }

    private static void createTree(Scanner sc, TreeNode node){
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
    public static void displayPretty(TreeNode node, int level){

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

    public static void nthLevel1(TreeNode root, List<Integer> li, int level){
        if(root == null) return;
        if(level == 1){
            li.add(root.val);
            return;
        }
        nthLevel1(root.left, li,level-1);
        nthLevel1(root.right, li,level-1);
    }
    public static void nthLevel2(TreeNode root, List<Integer> li, int level){
        if(root == null) return;
        if(level == 1){
            li.add(root.val);
            return;
        }
        nthLevel2(root.right, li,level-1);
        nthLevel2(root.left, li,level-1);
    }

    public static int height(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        int height = height(root) + 1;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=height;i++){
            List<Integer> li = new ArrayList<>();
            if(i%2 == 0){
                nthLevel1(root,li,i);
            }
            else {
                nthLevel2(root,li,i);
            }

            if(li.isEmpty()){
                continue;
            }
            res.add(li);
        }
        return res;
    }

    public static void main(String[] args) {
        createTree();
        System.out.println();
        displayPretty(root, 1);
        System.out.println();
        System.out.println(levelOrder(root));

    }

}


