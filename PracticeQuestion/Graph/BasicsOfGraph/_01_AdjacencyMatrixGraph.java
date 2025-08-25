package BasicsOfGraph;

import java.util.Scanner;

public class _01_AdjacencyMatrixGraph {
    private int[][] adjMatrix;
    private int V;

    public _01_AdjacencyMatrixGraph(int V){
        this.V = V;
        adjMatrix = new int[V][V];
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
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(adjMatrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int vertex,edge;
        System.out.println("Enter vertex:");
        vertex = sc.nextInt();

        System.out.println("Enter a edge");
        edge = sc.nextInt();

        _01_AdjacencyMatrixGraph graph = new _01_AdjacencyMatrixGraph(vertex);

        System.out.println("Enter a Edge Formate (u,v)");
        for(int i=0;i<edge;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printMatrix();

    }
}
