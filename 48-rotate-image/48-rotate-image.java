class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int[][] res = new int[m][m];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                res[i][j] = matrix[m-1-j][i];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=res[i][j];
            }
        }
    
        return ;
    }
}