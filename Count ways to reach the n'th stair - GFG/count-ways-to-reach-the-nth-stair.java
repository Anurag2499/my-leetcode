//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {   // Code here
        if(n==0 || n==1) return 1;
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++) dp[i]=-1;
        
        return nth(n,dp);
        
    }
    int nth(int n, int[] dp)
    {
        if(n==0 || n==1) return 1;
        
        if(dp[n]!=-1) return dp[n];
        
        return dp[n] = (nth(n-1,dp)+nth(n-2,dp))%1000000007;
    }
}


