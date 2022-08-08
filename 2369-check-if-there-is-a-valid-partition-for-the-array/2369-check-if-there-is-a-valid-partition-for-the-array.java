class Solution {
    public boolean validPartition(int[] nums) {
        // boolean[] dp = int dp[nums+1];
        HashMap<Integer,Boolean> memo = new HashMap<>();
        return partition(nums,0,memo);
    }
    private boolean partition(int[] nums, int start,HashMap<Integer,Boolean> memo)
    {
        if(start==nums.length) return true;
        
        int curr = start;
        if(memo.containsKey(curr))
        {
            return memo.get(curr);
        }
        
        boolean c1 =false,c2=false,c3=false;
        
        if(start+2<nums.length && nums[start]== nums[start+1] && nums[start+1]==nums[start+2]){
            c1 = partition(nums,start+3,memo);
        }
        if(start+2<nums.length && nums[start+1]== nums[start]+1 && nums[start+2]==nums[start+1]+1){
            c2 = partition(nums,start+3,memo);
        }
        if(start+1<nums.length && nums[start+1]==nums[start]){
            c3 = partition(nums,start+2,memo);
        }
        memo.put(start,c1||c2||c3);
        return c1||c2||c3;
        
    }
}