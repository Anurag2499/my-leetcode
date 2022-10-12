// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    
    public int knapSack(int W, int wt[], int val[], int N) 
    {
        int[][] t = new int[W+1][N+1];
        for(int i=0;i<W+1;i++){
            for(int j=0;j<N+1;j++){
                t[i][j]=-1;
            }       
        }
        return maxp(wt,val,0,W,N,t);
    } 
    private int maxp(int[] wt, int[] pro ,int ci, int cap, int n ,int[][] t)
    {
        if(ci==n || cap==0) return 0;
        
        if(t[cap][ci]!=-1) return t[cap][ci];
        
        int taken=0;
        if(wt[ci]<=cap){
            taken =pro[ci] + maxp(wt,pro,ci+1,cap-wt[ci],n,t);
        }
        int notTaken = maxp(wt,pro,ci+1,cap,n,t);
        
        return t[cap][ci] = Math.max(taken,notTaken);
    }
}


