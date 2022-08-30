class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        
        
//         just reversed the rows
        for(int col=0;col<m;col++){
            for(int row=0;row<m/2;row++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[m-1-row][col];
                matrix[m-1-row][col]  = temp;
            }
        }
        
        
//         single transpose
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        
        // int[][] res = new int[m][m];
        
        
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<m;j++){
        //         res[i][j] = matrix[m-1-j][i];
        //     }
        // }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<m;j++){
        //         matrix[i][j]=res[i][j];
        //     }
        // }
    
        return ;
    }
}