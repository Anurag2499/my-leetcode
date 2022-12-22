//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        int[] pathvis = new  int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0){
                if(dfs(V,i,adj,vis,pathvis)==true) return true;
            }
        }
        return false;
    }
    public boolean dfs(int V,int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis)
    {
        if(vis[node]==1){
                return true;
            }
        vis[node] = 1;
        pathvis[node] =1;
        for(Integer i : adj.get(node))
        {
            if(pathvis[i]==1 && vis[i]==1){
                return true;
            }
            else if(vis[i]==0 ) {
                if(dfs(V,i,adj,vis,pathvis)) return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
}