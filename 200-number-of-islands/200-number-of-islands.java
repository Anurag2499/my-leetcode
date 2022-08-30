class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row==0) return 0;
        int col = grid[0].length;
        
        int islandCount=0;
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    markIsland(grid,i,j,row,col);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    public void markIsland(char[][] grid, int i, int j, int row,int col){
        if(i>=row || i<0 || j>=col || j<0 || grid[i][j]!='1')
            return;
        
        grid[i][j] = '2';
        
        markIsland(grid,i,j+1,row,col);
        markIsland(grid,i+1,j,row,col);
        markIsland(grid,i,j-1,row,col);
        markIsland(grid,i-1,j,row,col);
        return ;
        
    }
}