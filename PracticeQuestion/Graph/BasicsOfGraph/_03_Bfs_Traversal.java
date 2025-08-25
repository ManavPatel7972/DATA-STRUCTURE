package BasicsOfGraph;

import java.util.Scanner;
import java.util.*;

public class _03_Bfs_Traversal {

    int V;
    int[] vis;
    List<List<Integer>> adj;

    public _03_Bfs_Traversal(int V){
        this.V = V;
        adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void bfs(int node){
        int[] vis = new int[V];
        Queue<Integer> q = new LinkedList<>();

        vis[node] = 1;
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int j=0;j<adj.get(curr).size();j++){
                int near = adj.get(curr).get(j);

                if(vis[near] == 0){
                    vis[near] = 1;
                    q.add(near);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        _03_Bfs_Traversal g = new _03_Bfs_Traversal(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);

        g.bfs(0);

    }
}
