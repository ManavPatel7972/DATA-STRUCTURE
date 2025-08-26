package BasicsOfGraph;

import java.util.ArrayList;

public class _04_Dfs_Traversal {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    public _04_Dfs_Traversal(int V){
        this.V = V;
        adj = new ArrayList<>();


        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void dfs(int node,int[] vis){
        vis[node] = 1;
        System.out.print(node + " ");

        for(int i=0;i<adj.get(node).size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                int near = adj.get(i).get(j);
                if(vis[near] == 0){
                    dfs(near,vis);
                }
            }
        }
    }

    public static void main(String[] args) {

        _04_Dfs_Traversal g = new _04_Dfs_Traversal(4);
        g.addEdge(0,1);
        g.addEdge(0,0);
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(2,1);

        int[] vis = new int[4];
        g.dfs(0,vis);
    }

}
