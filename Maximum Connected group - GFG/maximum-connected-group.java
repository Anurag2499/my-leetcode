//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisJointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisJointSet(int n)
    {
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node==parent.get(node)) return node;

        int prePar = findUPar(parent.get(node));
        parent.set(node,prePar);
        return parent.get(node);
    }

    public void UnionBySize(int u, int v)
    {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if(pu==pv) return ;

        if(size.get(pu)<size.get(pv)){
            parent.set(pu,pv);
            size.set(pv,size.get(pv)+size.get(pu));
        }
        else{
            parent.set(pv,pu);
            size.set(pu,size.get(pv)+size.get(pu));
        }
    }
}


class Solution {
    public boolean isValid(int row, int col ,int n)
    {
        return row>=0 && col>=0 && row<n && col<n;
    }
    
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        DisJointSet ds = new DisJointSet(m*n);
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        // step 1 done
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int newrow = i+ dx[k];
                        int newcol = j+ dy[k];
                        
                        if(isValid(newrow,newcol,n) && grid[newrow][newcol]==1){
                            
                            int node = i*m + j;
                            int newnode = newrow*m + newcol;
                            if(ds.findUPar(node)!=ds.findUPar(newnode)){
                                ds.UnionBySize(node,newnode);
                            }
                        }
                    }
                }
            }
        }
        // step 2 
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Set<Integer> set = new HashSet<>();
                if(grid[i][j]==0){
                    for(int k=0;k<4;k++){
                        int newrow = i+dx[k];
                        int newcol = j+dy[k];
                        
                        if(isValid(newrow,newcol,n) && grid[newrow][newcol]==1){
                            int node = newrow*n + newcol;
                            int parnode = ds.findUPar(node);
                            set.add(parnode);
                        }
                    }
                    
                    int count=0;
                    for(Integer pare : set){
                        count+= ds.size.get(pare); 
                    }
                    ans = Math.max(ans,count+1);
                }
            }
        }
        for(int ci=0;ci<n*n;ci++){
            ans = Math.max(ans, ds.size.get(ds.findUPar(ci)));
        }
        return ans;
        
    }
    
}


















