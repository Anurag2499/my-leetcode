//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int key;
    int val;
    Pair(int key,int val){
        this.key=key;
        this.val=val;
    }
}

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=  grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid, i,j,list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    int[] dx ={0,1,0,-1};
    int[] dy ={1,0,-1,0};
    void dfs(int i, int j , int[][] vis, int[][] grid, int baseI, int baseJ, ArrayList<String> list)
    {
        int n=  grid.length;
        int m = grid[0].length;
        vis[i][j]=1;
        // list.add(new Pair(i-baseI, j-baseJ));
        list.add(toString(i-baseI, j-baseJ));
        for(int k=0;k<4;k++){
            int newrow = i+dx[k];
            int newcol = j+dy[k];
            
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && grid[newrow][newcol]==1){
                dfs(newrow,newcol,vis,grid,baseI,baseJ,list);
            }
        }
        return ;
    }
    String toString(int i, int j){
        return Integer.toString(i)+"-"+Integer.toString(j);
    }
}
















