//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair{
    int key;
    int val;
    int time;
    Pair(int key, int val,int time)
    {
        this.key=key;
        this.val=val;
        this.time = time;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                
            }
        }
        int ans=0;
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.key;
            int col = p.val;
            int currtime = p.time;
            
            for(int k=0;k<4;k++)
            {
                int newrow = row+dx[k];
                int newcol = col+dy[k];
                
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==1 && vis[newrow][newcol]==0)
                {
                    vis[newrow][newcol]=1;
                    q.add(new Pair(newrow,newcol,currtime+1));
                    ans=Math.max(ans,currtime+1);
                }
            }
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1){
                    if(vis[i][j]==0) return -1;
                }
            }
        }
        return ans;
    }
}









