public class 1143-Longest-Common-Subsequence {
    
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[] prev = new int[n2+1];

        for(int i=n1-1;i>=0;i--){
            int[] curr  = new int[n2+1];
            for(int j=n2-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    curr[j] =  1+ prev[j+1];
                }
                else {
                    curr[j] = Math.max(curr[j+1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }
    public int lcs(String s1, String s2, int i1, int i2, int[][] dp)
    {
        int n1 = s1.length();
        int n2 = s2.length();

        if(i1>=n1 || i2>=n2) return 0;

        if(dp[i1][i2]!=0) return dp[i1][i2];
        
        if(s1.charAt(i1)==s2.charAt(i2)){
            return dp[i1][i2] =  1+ lcs(s1,s2,i1+1,i2+1,dp);
        }
        else {
            return dp[i1][i2] = Math.max(lcs(s1,s2,i1,i2+1,dp), lcs(s1,s2,i1+1,i2,dp));
        }
    }
}