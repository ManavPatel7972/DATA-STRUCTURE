package BasicsOfGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class _05_Convert_AdjMatrixToAdjList {

    int V;
    ArrayList<ArrayList<Integer>> adj;
    private int[][] adjMatrix;

    public _05_Convert_AdjMatrixToAdjList(int V){
        this.V = V;
        adj = new ArrayList<>();
        adjMatrix = new int[V+1][V+1];

        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

    }

    public void matrixToList(){
        int n = adjMatrix.length;

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(adjMatrix[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        System.out.println("List ::");
        for(int i=1;i<=V;i++){
            System.out.print( i + " -> ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }


    public void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }
    public void removeEdge(int u, int v){
        adjMatrix[u][v] = 0;
        adjMatrix[v][u] = 0;
    }
    public void printMatrix(){
        System.out.println("Matrix:");
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                System.out.print(adjMatrix[i][j] + " ");

            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertex,edge;
        System.out.println("Enter vertex:");
        vertex = sc.nextInt();

        System.out.println("Enter a edge");
        edge = sc.nextInt();

       _05_Convert_AdjMatrixToAdjList g = new _05_Convert_AdjMatrixToAdjList(vertex);

        System.out.println("Enter a Edge Formate (u,v)");
        for(int i=1;i<=edge;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.println(g.adj);
        g.printMatrix();
        System.out.println();
        g.matrixToList();
        System.out.println(g.adj);
    }
}
