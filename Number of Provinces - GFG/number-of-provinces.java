//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();
        for(int i=0;i<V;i++) adjL.add(new ArrayList<Integer>());
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(adj.get(i).get(j)==1 && i!=j){
                    adjL.get(i).add(j);
                    adjL.get(j).add(i);
                }
            }
        }
        
        int count=0;
        int[] vis = new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                count++;
                dfs(adjL,i,vis);
            }
        }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adjL, int node,int[] vis)
    {
        vis[node] = 1;
        
        for(Integer it: adjL.get(node))
        {
            if(vis[it]==0){
                dfs(adjL,it,vis);
            }
        }
        return ;
    }
};