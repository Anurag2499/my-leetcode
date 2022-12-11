//{ Driver Code Starts
// Initial Template for Java

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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || i==n-1) && grid[i][j]==1) dfs(i,j,vis,grid);
                else if((j==0 || j==m-1) && grid[i][j]==1) dfs(i,j,vis,grid);
            }
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1) count++;
            }
        }
        return count;
    }
    int[] dx ={-1,0,1,0};
    int[] dy = {0,1,0,-1};
    void dfs(int i,int j,int[][] vis, int[][] grid)
    {
        vis[i][j]=1;
        
        int n=grid.length;
        int m=  grid[0].length;
        
        for(int k=0;k<4;k++){
            int newRow = i+dx[k];
            int newCol = j+dy[k];
            
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==0 && grid[newRow][newCol]==1){
                dfs(newRow,newCol,vis,grid);
            }
        }
        return ;
        
    }
}









