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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int key;
    int val;
    int dis;
    Pair(int key,int val,int dis){
        this.key= key;
        this.val =val;
        this.dis= dis;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        int[] dx= {-1,0,1,0};
        int[] dy ={0,-1,0,1};
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            int row = p.key;
            int col = p.val;
            int d = p.dis;
            
            for(int k=0;k<4;k++)
            {
                int newrow=row+dx[k];
                int newcol = col+dy[k];
                
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && grid[newrow][newcol]==0){
                    vis[newrow][newcol]=1;
                    q.add(new Pair(newrow,newcol,d+1));
                    ans[newrow][newcol]=d+1;
                }
            }
        }
        return ans;
        
    }
}