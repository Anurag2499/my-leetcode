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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair{
    int key;
    int val;
    Pair(int key, int val)
    {
        this.key=key;
        this.val=val;
    }
}
class Solution {
    // Function to find the number of islands.
    int[] dx = {0,0,1,1,1,-1,-1,-1};
    int[] dy = {-1,1,1,-1,0,1,-1,0};
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m= grid[0].length;
        
        int count=0;
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    count++;
                    bfs(grid,vis,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int[][] vis, int row,int col)
    {
        vis[row][col]=1;
        int n=grid.length;
        int m = grid[0].length;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(row,col));
        
        while(!q.isEmpty())
        {
            int i=q.peek().key;
            int j=q.peek().val;
            q.remove();
            
            
            
            for(int x=-1;x<2;x++) {
                for(int y=-1; y<2; y++) {
                    int newRow= i+x;
                    int newCol = j+y;
                    if(newRow>=0&& newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol] == '1' && vis[newRow][newCol]==0 )
                    {
                        vis[newRow][newCol]=1;
                        q.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
        
        return ;
    }
}




