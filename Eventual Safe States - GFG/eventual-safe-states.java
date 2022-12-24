//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check  = new int[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(V,i,adj,vis,pathvis,check);
            }
            
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
    
    Boolean dfs(int V, int node,List<List<Integer>> adj,int[] vis, int[] pathvis, int[] check)
    {
        vis[node]=1;
        pathvis[node]=1;
        check[node] = 0;
        
        for(Integer i: adj.get(node))
        {
            if(vis[i]==0)
            {
                if(dfs(V,i,adj,vis,pathvis,check))return true;
            }
            else if(pathvis[i]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
        
    }
    
}


















