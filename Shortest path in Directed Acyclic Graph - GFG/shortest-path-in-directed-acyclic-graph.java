//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void dfs(int N, int node, int[] vis, ArrayList<ArrayList<Pair>> adj , Stack<Integer> st)
	{
	    vis[node]=1;
	    
	    for(Pair p : adj.get(node))
	    {
	        int newNode = p.first;
	        if(vis[newNode]==0){
	            dfs(N,newNode,vis,adj,st);
	        }
	    }
	    st.push(node);
	    return ;
	}

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<N;i++)
		{
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int i=0;i<edges.length;i++)
		{
		    adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		Stack<Integer> st=  new Stack<>();
		int[] vis=  new int[N];
		dfs(N,0,vis,adj,st);
		
		int[] dist = new int[N];
		
		for(int i=0;i<N;i++) dist[i]= Integer.MAX_VALUE;
		
		dist[0] = 0;
		
		while(!st.isEmpty())
		{
		    int node = st.pop();
		    
		    for(Pair p : adj.get(node))
		    {
		        int val = p.first;
		        int dis = p.second;
		        
		        dist[val]  = Math.min(dist[val], dist[node]+ dis);
		    }
		}
		for(int i=0;i<N;i++) if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
		return dist;
		
	}
	
	
}















