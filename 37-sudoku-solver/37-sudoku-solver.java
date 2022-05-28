class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board,0,0,board.length);
        return ;
    }
    private boolean sudokuSolver(char[][] board, int crow,int ccol,int n)
    {
        if(crow==n)
            return true;
        
        int nextrow=-1;
        int nextcol=-1;
        
        if(ccol!=n-1)
        {
            nextrow=crow;
            nextcol=ccol+1;
        }
        else{
            nextrow=crow+1;
            nextcol=0;
        }
        
        if(board[crow][ccol]!= '.')
        {
            return sudokuSolver(board,nextrow,nextcol,n);
        }
        for(char currentval='1';currentval<='9';currentval++)
        {
            if(isValid(board,crow,ccol,currentval,n))
            {
                board[crow][ccol]=currentval;
                if(sudokuSolver(board,nextrow,nextcol,n))
                    return true;
                board[crow][ccol]='.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int crow,int ccol,char currentval, int n)
    {
        return ( isrowValid(board,crow,currentval,n) 
           && iscolValid(board,ccol,currentval,n)
           && isgridValid(board,crow,ccol,currentval,n));
    }
    private boolean isrowValid(char[][] board, int crow, char currentval,int n){
        for(int i=0;i<n;i++)
        {
            if(board[crow][i]==currentval)
                return false;
        }
        return true;
    }
    private boolean iscolValid(char[][] board, int ccol, char currentval,int n){
        for(int i=0;i<n;i++)
        {
            if(board[i][ccol]==currentval)
                return false;
        }
        return true;
    }
    private boolean isgridValid(char[][] board, int crow,int ccol, char currentval,int n){
        int rowstart = 3*(crow/3);
        int colstart = 3*(ccol/3);
        
        for(int i=rowstart;i<=rowstart+2;i++)
        {
            for(int j=colstart;j<=colstart+2;j++)
            {
                if(board[i][j]==currentval)
                    return false;
            }
        }
        return true;
    }
    
}

















