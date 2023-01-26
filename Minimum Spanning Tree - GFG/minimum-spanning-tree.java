//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class DisJointset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    
    DisJointset(int n)
    {
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    
    public int findUParent( int node){
        if(node == parent.get(node)) return node;
        int pre = findUParent(parent.get(node));
        parent.set(node,pre);
        return parent.get(node);
    }
    
    public void UnionSet(int u, int v){
        int pu = findUParent(u);
        int pv = findUParent(v);
        
        if(pu==pv) return ;
        if(rank.get(pu)<rank.get(pv)){
            parent.set(pu,pv);
        }
        else if(rank.get(pu)>rank.get(pv)){
            parent.set(pv,pu);
        }
        else{
            parent.set(pu,pv);
            rank.set(pv,rank.get(pv)+1);
        }
    }
}
class Tuple implements Comparable<Tuple>{
    int first;
    int sec;
    int third;
    
    Tuple(int first, int sec, int third){
        this.first=first;
        this.sec = sec;
        this.third = third;
    }
    public int compareTo(Tuple compareTuple){
        return this.first- compareTuple.first;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<Tuple> adj = new ArrayList<>();
	    
	    for(int i=0;i<edges.length;i++){
	        adj.add(new Tuple(edges[i][2],edges[i][0],edges[i][1]));
	    }
	    
	    DisJointset ds = new DisJointset(V);
	    
	    Collections.sort(adj);
	    
	    int mst=0;
	    for(int i=0;i<adj.size();i++)
	    {
	        int u = adj.get(i).sec;
	        int v = adj.get(i).third;
	        int wt = adj.get(i).first;
	        if(ds.findUParent(u)!=ds.findUParent(v)){
	            mst+=wt;
	            ds.UnionSet(u,v);
	        }
	    }
	    return mst;
	    
	    
	    
	    
	    
	}
}



















