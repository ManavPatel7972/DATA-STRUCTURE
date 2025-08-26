package BasicsOfGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _06_Convert_AdjListToAdjMatrix {

    int V;
    ArrayList<ArrayList<Integer>> adj;
    int[][] adjMatrix;

    public _06_Convert_AdjListToAdjMatrix(int V){
        this.V = V;
        adj = new ArrayList<>();
        adjMatrix = new int[V + 1][V + 1]; // 1-based indexing

        for(int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void listToMatrix(){
        for(int i = 1; i <= V; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                int neighbour = adj.get(i).get(j);
                adjMatrix[i][neighbour] = 1;
            }
        }

        System.out.println("Matrix:");
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printList(){
        System.out.println("List:");
        for(int i = 1; i <= V; i++){
            System.out.print(i + " -> ");
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertex, edge;
        System.out.print("Enter number of vertices: ");
        vertex = sc.nextInt();

        System.out.print("Enter number of edges: ");
        edge = sc.nextInt();

        _06_Convert_AdjListToAdjMatrix g = new _06_Convert_AdjListToAdjMatrix(vertex);

        System.out.println("Enter each edge in format (u v):");
        for(int i = 1; i <= edge; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.println();
        g.printList();
        System.out.println(Arrays.deepToString(g.adjMatrix));
        System.out.println();
        g.listToMatrix();
        System.out.println();
        System.out.println(Arrays.deepToString(g.adjMatrix));
    }
}
