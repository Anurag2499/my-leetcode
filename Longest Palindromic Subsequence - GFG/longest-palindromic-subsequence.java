//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        // so in this problem we have to take the longest  subsequnece part 
        //  and which is palindrome 
        
        //  so we will do this by reversing the string and then finding the LCS of both the String
        
        String reverse  = "";
        for(int i=S.length()-1;i>=0;i--){
            reverse+=S.charAt(i);
        }
        
        int m = S.length();
        
        int[][] dp  = new int[m+1][m+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<m+1;j++){
                if(S.charAt(i-1)==reverse.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][m];
        
    }
    
}