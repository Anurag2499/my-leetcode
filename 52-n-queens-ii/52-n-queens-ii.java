class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        ways(board,0,n,ans);
        int v= ans.size();
        return v;
    }
    private void ways(char[][] board, int crow, int n ,List<List<String>> ans)
    {
        if(crow==n)
        {
            ans.add(tolist(board,n));
            return ;
        }
        
        for(int ccol=0;ccol<n;ccol++)
        {
            if(isValid(board,crow,ccol,n))
            {
                board[crow][ccol]='Q';
                ways(board,crow+1,n,ans);
                board[crow][ccol]='.';
            }
        }
        return;
    }
    private List<String> tolist(char[][] board,int n)
    {
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String current="";
            for(int j=0;j<n;j++)
                current+=board[i][j];
            res.add(current);
        }
        return res;
    }
    private boolean isValid(char[][] board, int crow,int ccol,int n)
    {
        return isrowValid(board,crow,n) && iscolValid(board,ccol,n) && isDiaValid(board,crow,ccol,n);
    }
    
    private boolean isrowValid(char[][] board, int crow, int n)
    {
        for(int i=0;i<n;i++)
        {
            if(board[crow][i]=='Q')
                return false;
        }
        return true;
    }
    private boolean iscolValid(char[][] board, int ccol, int n)
    {
        for(int i=0;i<n;i++)
        {
            if(board[i][ccol]=='Q')
                return false;
        }
        return true;
    }
    private boolean isDiaValid(char[][] board, int crow,int ccol,int n)
    {
        int x=crow;
        int y=ccol;
        
        while(x>=0 && y>=0)
        {
            if(board[x][y]=='Q')
                return false;
            x-=1;
            y-=1;
        }
        x=crow;
        y=ccol;
        
        while(x>=0 && y<n)
        {
            if(board[x][y]=='Q')
                return false;
            x-=1;
            y+=1;
        }
        return true;
    }
}