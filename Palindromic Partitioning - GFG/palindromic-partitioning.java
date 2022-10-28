//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        int[][] dp  =new int[n+1][n+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return pp(str,0,n-1,dp);
        
    }
    
    static int pp(String str, int i,int j,int[][] dp)
    {
        if(ispalin(str,i,j)==true) return 0;
        if(i>=j) return 0;
        
        if(dp[i][j] !=-1) return dp[i][j];
        
        int ans=Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++)
        {
            int temp = pp(str,i,k,dp) + pp(str,k+1,j,dp) + 1;
            ans = Math.min(temp,ans);
        }
        return dp[i][j] = ans;
    }
    
    static boolean ispalin(String s , int i, int j)
    {
        if(i>=j) return true;
        
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    
}