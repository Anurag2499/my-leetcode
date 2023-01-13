//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class tuple{
    int step;
    int node;
    int dis;
    
    tuple(int step, int node, int dis)
    {
        this.step = step;
        this.node = node;
        this.dis = dis;
    }
    
}
class Pair{
    int node;
    int dis;
    Pair(int node, int dis)
    {
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        Queue<tuple> q = new LinkedList<>();
        
        q.add(new tuple(0,src,0));
        
        while(!q.isEmpty())
        {
            tuple t = q.remove();
            int steps = t.step;
            int node = t.node;
            int dis = t.dis;
            
            if(steps>k) continue;
            
            
            for(Pair p : adj.get(node))
            {
                int newNode = p.node;
                int adjdis = p.dis;
                
                if(dist[newNode] > dis + adjdis){
                    dist[newNode] = dis + adjdis;
                    q.add(new tuple(steps+1, newNode, dist[newNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dist[dst];
        
    }
}











