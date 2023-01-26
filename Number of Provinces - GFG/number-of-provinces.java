//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
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
            size.set(pv,size.get(pv)+size.get(pu));
        }
    }
}

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        DisJointSet ds = new DisJointSet(V);
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(0).size();j++)
            {
                if(adj.get(i).get(j)==1){
                    ds.UnionBySize(i,j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++){
            if(ds.findUPar(i)==i) cnt++;
        }
        return cnt;
        
    }
};


















