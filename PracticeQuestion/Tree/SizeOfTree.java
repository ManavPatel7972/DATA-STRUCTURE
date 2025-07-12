package PracticeQuestion.Tree;

import java.util.Scanner;

public class SizeOfTree {
     public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;

        }
    }

    static Node root = null;

    static Scanner sc = new Scanner(System.in);

     public static void createTree(){
    System.out.println("Enter a Root Node : ");
    int val = sc.nextInt();
    root = new Node(val);
    createTree(sc,root);
    }

    private static void createTree(Scanner sc,Node node){
    System.out.println("left of " + node.val + " (Yes -> 1)(No -> 0)");
    int left = sc.nextInt();

    if(left==1){
    System.out.println("Enter the value of the left of " + node.val);
    int val = sc.nextInt();
    node.left = new Node(val);
    createTree(sc,node.left);
    }

    System.out.println("right of " + node.val + " (Yes -> 1)(No -> 0)");
    int right = sc.nextInt();
    if(right==1){
    System.out.println("Enter the value of the right of " + node.val);
    int val = sc.nextInt();
    node.right = new Node(val);
    createTree(sc,node.right);
    }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        display(node.left);
        display(node.right);

    }
    public static void displayPretty(Node node,int level){

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

    public static int size(Node root){
        if(root == null) return 0;
        return  1 + size(root.left) + size(root.right);
    }

    public static void main(String[] args) {
       createTree();
       display(root);
       System.out.println();
       displayPretty(root, 1);
       System.out.println("Size = " + size(root));
    }

}
