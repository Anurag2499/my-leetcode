//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int key;
    int val;
    Pair(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(detectCycle(i,adj,vis)) return true;
            }
        }
        return false;
    }
    
    public boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, int[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src]=1;
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            int node = p.key;
            int parent = p.val;
            
            for(Integer i: adj.get(node))
            {
                if(vis[i]==0){
                    vis[i]=1;
                    q.add(new Pair(i,node));
                }
                else if(i!=parent) return true;
            }
        }
        return false;
    }
}

