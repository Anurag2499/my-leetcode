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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class DisJointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size  = new ArrayList<>();
    
    DisJointSet(int n){
        for(int i=0;i<=n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)) return node;
        
        int prev = findUPar(parent.get(node));
        parent.set(node,prev);
        return parent.get(node);
    }
    public void UnionSet(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        
        if(pu==pv) return ;
        if(size.get(pu)<size.get(pv)){
            parent.set(pu,pv);
            size.set(pv, size.get(pu)+ size.get(pv));
        }
        else{
            parent.set(pv,pu);
            size.set(pu, size.get(pu)+ size.get(pv));
        }
    }
}

class Solution {

    int maxRemove(int[][] stones, int n) {
        
        int maxrow = 0;
        int maxcol = 0;
        for(int i=0;i<n;i++){
            maxrow = Math.max(maxrow, stones[i][0]);
            maxcol = Math.max(maxcol, stones[i][1]);
        }
        DisJointSet ds = new DisJointSet(maxrow+maxcol+1);
        
        HashMap<Integer,Integer> stonesSet = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int row = stones[i][0];
            int col = stones[i][1]+ maxrow+1;
            
            ds.UnionSet(row,col);
            stonesSet.put(row,1);
            stonesSet.put(col,1);
        }
    
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry: stonesSet.entrySet())
        {
            if(ds.findUPar(entry.getKey())==entry.getKey()) cnt++;
        }
        return n-cnt;
    }
}
























