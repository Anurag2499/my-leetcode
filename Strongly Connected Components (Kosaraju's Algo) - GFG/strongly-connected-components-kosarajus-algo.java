//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(int i, int[] vis, Stack<Integer> st,ArrayList<ArrayList<Integer>> adj )
    {
        if(vis[i]==1) return;
        
        vis[i]=1;
        for(Integer nbr: adj.get(i)){
            if(vis[nbr]==0){
                dfs(nbr, vis,st,adj);
            }
        }
        st.push(i);
        return ;
    }
    public void dfs2(int i, int[] vis,ArrayList<ArrayList<Integer>> adj )
    {
        if(vis[i]==1) return;
        
        vis[i]=1;
        for(Integer nbr: adj.get(i)){
            if(vis[nbr]==0){
                dfs2(nbr, vis,adj);
            }
        }
        return ;
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                dfs(i,vis,st,adj);
            }
        }
        
        // reversing the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(Integer it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        
        // take out all nodes from stack
        int[] vis2 = new int[V];
        int count=0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(vis2[node]==0)
            {
                count++;
                dfs2(node,vis2,adjT);
            }
        }
        return count;
    }
}












