// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public ArrayList<String> findPath(int[][] grid, int n) {
        // Your code hereo
        ArrayList<String> ans = new ArrayList<String>();
        path(grid, 0,0,n,"",ans);
        return ans;
    }
    private void path(int[][] grid, int crow,int ccol,int n, String current, ArrayList<String> ans)
    {
        if(crow>=n || crow<0 || ccol>=n || ccol<0 || grid[crow][ccol]<=0)
        {
            return;
        }
        
        if(crow==n-1 && ccol==n-1)
        {
            ans.add(current);
            return;
        }
        
        grid[crow][ccol]=-1;
        
        // move D L R U
        path(grid, crow+1,ccol,n,current+"D",ans);
        path(grid, crow,ccol-1,n,current+"L",ans);
        path(grid, crow,ccol+1,n,current+"R",ans);
        path(grid, crow-1,ccol,n,current+"U",ans);
        
        grid[crow][ccol]=1;
        return;
    }
}