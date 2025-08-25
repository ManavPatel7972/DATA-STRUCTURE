package BasicsOfGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_AdjacencyListGraph {
    private List<List<Integer>> adjList;
    private int V;

    _02_AdjacencyListGraph(int V) {
        this.V = V;
        adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void removeEdge(int u, int v) {
        adjList.get(v).remove(u);
        adjList.get(u).remove(v);
    }

    public void printGraph() {
        System.out.println("Adjacency List::");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {

        int vertex, edge;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Vertex:");
        vertex = sc.nextInt();

        System.out.println("Enter a edge:");
        edge = sc.nextInt();

        _02_AdjacencyListGraph graph = new _02_AdjacencyListGraph(vertex);

        System.out.println("Enter a Edges Formate(u,v)");
        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printGraph();
    }
}
