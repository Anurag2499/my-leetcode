class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int robfirstH =maxrF(0,nums.length-1,nums,new HashMap<Integer,Integer>());
        int robsecondH =maxrF(1,nums.length,nums,new HashMap<Integer,Integer>());
        return Math.max(robfirstH,robsecondH);

    }
    private int maxrF(int ci ,int last,int[] nums,HashMap<Integer,Integer> memo)
    {
        // int n= nums.length;
        
        if(ci>=last)
            return 0;
        
        int currentKey  = ci;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        
        int rob = nums[ci] + maxrF(ci+2,last, nums,memo);
        int norob = maxrF(ci+1,last,nums,memo);
        
        memo.put(currentKey,Math.max(rob,norob));
        
        return Math.max(rob,norob);
    }
    
    private int maxrS(int ci ,int[] nums,HashMap<Integer,Integer> memo)
    {
        int n= nums.length;
        
        if(ci>=n)
            return 0;
        
        int currentKey  = ci;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        
        int rob = nums[ci] + maxrS(ci+2, nums,memo);
        int norob = maxrS(ci+1,nums,memo);
        
        memo.put(currentKey,Math.max(rob,norob));
        
        return Math.max(rob,norob);
    }
}