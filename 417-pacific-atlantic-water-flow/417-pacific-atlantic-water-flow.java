class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n= heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        if(heights.length==0 || heights[0].length==0)
            return ans;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int j=0;j<n;j++){
            dfs(0,j,pacific,heights,-1);
            
            dfs(m-1,j,atlantic,heights,-1);
        }
        for(int i=0;i<m;i++){
            dfs(i,0,pacific,heights,-1);
            
            dfs(i,n-1,atlantic,heights,-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]&& atlantic[i][j]){
                    List<Integer> indexes= new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    ans.add(indexes);
                }
            }
        }
        return ans;
    }
    void dfs(int i,int j,boolean[][] match ,int[][] heights, int prev){
        if(i<0 || j<0 || i>=match.length || j>=match[0].length || match[i][j] || heights[i][j]<prev){
            return ;
        }
        match[i][j]=true;
        dfs(i+1,j,match,heights,heights[i][j]);
        dfs(i-1,j,match,heights,heights[i][j]);
        dfs(i,j+1,match,heights,heights[i][j]);
        dfs(i,j-1,match,heights,heights[i][j]);

        
    }
}