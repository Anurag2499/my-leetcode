class Solution {
     public int[][] diagonalSort(int[][] A) {
        int m = A.length, n = A[0].length;
        HashMap<Integer, PriorityQueue<Integer>> memo = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(memo.containsKey(i-j)) memo.get(i-j).add(A[i][j]);
                else {
                    memo.put(i-j , new PriorityQueue<>());
                    memo.get(i-j).add(A[i][j]);
                }   
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                A[i][j] = memo.get(i - j).poll();
        return A;
    }
}