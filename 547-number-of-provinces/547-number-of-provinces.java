class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        
        boolean[] visited = new boolean[n];
        int ans=0;
        for(int currentCity =0;currentCity<n;currentCity++)
        {
            if(visited[currentCity]==false)
            {
                dfs(graph,currentCity,n,visited);
                ans+=1;
            }
        }
        return ans;
    }
    private void dfs(int[][] graph, int currentCity, int n, boolean[] visited)
    {
        if(visited[currentCity]==true)
            return;
        
        visited[currentCity]=true;
        
        int[] neighs = graph[currentCity]; 
        for(int i=0;i<n;i++)
        {
            if(neighs[i]==1)
                dfs(graph,i,n,visited);
        }
        return ;
    }
    
    
}