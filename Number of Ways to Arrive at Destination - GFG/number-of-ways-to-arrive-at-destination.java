//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int sec;
    Pair(int first, int sec)
    {
        this.first = first;
        this.sec = sec;
    }
}

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>> adj  =new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> l: roads)
        {
            adj.get(l.get(0)).add(new Pair(l.get(1),l.get(2)));
            adj.get(l.get(1)).add(new Pair(l.get(0),l.get(2)));
        }
        
        int[] dist = new int[n];
        int[] ways = new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        ways[0]=1;
        dist[0]=0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.first-b.first);
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty())
        {
            Pair p = pq.remove();
            int distance = p.first;
            int node = p.sec;
            
            for(Pair nbrPair: adj.get(node))
            {
                int newnode = nbrPair.first;
                int newdist = nbrPair.sec;
                
                
                if(dist[newnode]>distance+ newdist)
                {
                    dist[newnode] = distance+newdist;
                    ways[newnode] = ways[node];
                    pq.add(new Pair(dist[newnode],newnode));
                }
                else if(dist[newnode] == distance+ newdist)
                {
                    // dist[newnode] = distance+newdist;
                    ways[newnode] += ways[node];
                }
            }
        }
        return ways[n-1];
        
        
    }
    
}

















