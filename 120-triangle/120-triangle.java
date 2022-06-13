class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        HashMap<String,Integer> memo = new HashMap<>();
        int n = triangle.size();
        int res = mintotal(triangle,0,0,n,memo);
        return res;
    }
    
    private int mintotal(List<List<Integer>> triangle, int crow,int ccol,int n,HashMap<String,Integer> memo)
    {
        if(crow==n)
            return 0;
        String currentKey = crow+"-"+ccol;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int value = triangle.get(crow).get(ccol);
        
        int down = value+mintotal(triangle,crow+1,ccol,n,memo);
        int right = value+mintotal(triangle,crow+1,ccol+1,n,memo);
        
        memo.put(currentKey,Math.min(down,right));
        
        return  Math.min(down,right);

    }
}