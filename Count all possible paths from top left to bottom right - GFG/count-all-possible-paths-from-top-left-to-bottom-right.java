// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
        long[][] grid = new long[m][n];
        
        // first column assigning 1
        for(int i=0;i<m;i++)
        {
            grid[i][0]=1;
        }
        
        // first row assigning 1
        for(int j=0;j<n;j++)
        {
            grid[0][j]=1;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                grid[i][j]= (grid[i-1][j]+grid[i][j-1])%(1000000007);
            }
        }
        return grid[m-1][n-1];
    
    }
    
}