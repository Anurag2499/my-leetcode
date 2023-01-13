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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int x;
    int y;
    Pair(int first, int x, int y){
        this.first=first;
        this.x=x;
        this.y=y;
    }
}

class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.first-y.first);
        pq.add(new Pair(0,source[0],source[1]));
        
        
        
        int m = grid.length;
        int n= grid[0].length;
        int[][] distance = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[source[0]][source[1]]=0;
        
        while(!pq.isEmpty())
        {
            Pair p = pq.remove();
            int dist = p.first;
            int x = p.x;
            int y = p.y;
            
            if(x==destination[0] && y==destination[1]){
                return dist;
            } 
            
            for(int i=0;i<4;i++){
                int newx = x+dx[i];
                int newy = y+dy[i];
                if(newx>=0 && newx<m && newy>=0 && newy<n && grid[newx][newy]==1 && distance[newx][newy]>dist+1){
                    pq.add(new Pair(dist+1,newx,newy));
                    distance[newx][newy]=dist+1;
                }
            }
        }
        return -1;
        
        
    }
}
