//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class tuple{
    int first;
    int x;
    int y;
    tuple(int first,int x,int y){
        this.first=first;
        this.x=x;
        this.y=y;
    }
}

class Solution {
    int[] dx =  {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int ans = Integer.MAX_VALUE;
    
    int MinimumEffort(int heights[][]) {
        int m =heights.length;
        int n= heights[0].length;
        
        int[][] diff = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                diff[i][j]=Integer.MAX_VALUE;
            }
        }
        diff[0][0]=0;
        
        PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x,y)->x.first-y.first);
        pq.add(new tuple(0,0,0));
        
        while(!pq.isEmpty())
        {
            tuple t = pq.remove();
            int nodediff = t.first;
            int x = t.x;
            int y = t.y;
            
            if(x==m-1 && y==n-1){
                return nodediff;
            }
            
            for(int i=0;i<4;i++)
            {
                int newx  = x+dx[i];
                int newy = y+dy[i];
                
                
                if(newx>=0 && newx<m && newy>=0 && newy<n  ){
                    int newdiff = Math.abs(heights[newx][newy] - heights[x][y]);
                    int effrt = Math.max(newdiff, nodediff);
                    if(effrt < diff[newx][newy]){
                        diff[newx][newy]=effrt;
                        pq.add(new tuple(effrt,newx,newy));
                    }
                    // else{
                    //     diff[newx][newy]  = nodediff;
                    //     pq.add(new tuple(nodediff,newx,newy));
                    // }
                }
            }
            
        }
        return -1;
        
        
    }
}