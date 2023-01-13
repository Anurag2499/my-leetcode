//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int step;
    int node;
    Pair(int step, int node){
        this.step = step;
        this.node = node;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int[] dist = new int[100000];
        for(int i=0;i<100000;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start]=0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,start));
        
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            int steps = p.step;
            int node = p.node;
            
            for(int i=0;i<arr.length;i++){
                int newnode = node* arr[i];
                newnode = newnode%100000;
                
                if(dist[newnode]>steps+1){
                    dist[newnode] = steps+1;
                    if(newnode==end) return steps+1;
                    q.add(new Pair(steps+1, newnode));
                }
            }
        }
        return -1;
        
    }
}
