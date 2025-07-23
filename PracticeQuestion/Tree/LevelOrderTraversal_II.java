package BT;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevelOrderTraversal_II {
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

    public static int height(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static void helper(TreeNode root,int level,List<Integer> li){
        if(root == null) return;
        if(level == 1){
            li.add(root.val);
        }
        helper(root.left,level-1,li);
        helper(root.right,level-1,li);

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = height(root) + 1;
        for(int i=level;i>=1;i--){
            List<Integer> li = new ArrayList<>();
            helper(root,i,li);
            if(li.isEmpty()){
                continue;
            }
            res.add(li);
        }
        return res;
    }



    public static void main(String[] args) {
        createTree();
        display(root);
        System.out.println();
        List<List<Integer>> li = levelOrderBottom(root);
        System.out.println(li);
    }

}

