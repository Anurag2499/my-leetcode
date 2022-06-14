class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        
        for(int[] currentTrust : trust)
        {
            int a= currentTrust[0];
            int b= currentTrust[1];
            
            indegree[b]+=1;
            outdegree[a]+=1;
        }
        
        for(int currentpeople=1;currentpeople<=n;currentpeople++)
        {
            if(indegree[currentpeople]==n-1 && outdegree[currentpeople]==0)
                return currentpeople;
        }
        return -1;
    }
}