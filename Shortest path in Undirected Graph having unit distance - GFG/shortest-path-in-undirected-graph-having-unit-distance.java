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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

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
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][1]).add(edges[i][0]);
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty())
        {
            int node = q.remove();
            
            for(Integer i : adj.get(node))
            {
                if(ans[node]+1 < ans[i]){
                    ans[i] = ans[node]+1;
                    q.add(i);
                }
            }
        }
        for(int i=0;i<n;i++) {
            if(ans[i]== Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
    
}
















