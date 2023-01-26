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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisJointSet{
    List<Integer> parent= new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisJointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par = findUPar(parent.get(node));
        parent.set(node,par);
        return parent.get(node);
    }
    public void UnionFind(int u, int v)
    {
        int pu = findUPar(u);
        int pv = findUPar(v);
        
        if(pu==pv) return ;
        if(size.get(pu)<size.get(pv))
        {
            parent.set(pu,pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }
        else{
            parent.set(pv,pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
        
    }
}

class Solution {

    public int Solve(int n, int[][] edge) {
        
        int extra=0;
        DisJointSet ds = new DisJointSet(n);
        
        for(int i=0;i<edge.length;i++){
            if(ds.findUPar(edge[i][0])==ds.findUPar(edge[i][1])){
                extra++;
                continue;
            }
            
            ds.UnionFind(edge[i][0],edge[i][1]);
        }
        
        int component_Count=0;
        for(int i=0;i<n;i++){
            if(ds.findUPar(i)==i) component_Count++;
        }
        
        if(extra>=component_Count-1) return component_Count-1;
        return -1;
        
    }
}



















