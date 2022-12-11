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

class Pair{
    int key;
    int col;
    Pair(int key,int col){
        this.key=key;
        this.col =col;
    }
}
class Solution {
    int[] dx={-1,0,1,0};
    int[] dy ={0,-1,0,1};

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=  grid.length;;
        int m= grid[0].length;
        
        int[][] vis = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || i==n-1) && grid[i][j]==1){
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                }
                else if((j==0 || j==m-1) && grid[i][j]==1){
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p= q.remove();
            int row = p.key;
            int col = p.col;
            
            for(int k=0;k<4;k++){
                int newRow = row+ dx[k];
                int newCol  = col+ dy[k];
                
                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]==1 && vis[newRow][newCol]==0){
                    q.add(new Pair(newRow,newCol));
                    vis[newRow][newCol] = 1;
                }
            }
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}












