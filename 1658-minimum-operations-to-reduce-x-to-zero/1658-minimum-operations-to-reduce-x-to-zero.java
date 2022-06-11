class Solution {
    public int minOperations(int[] nums, int x) {
        int totalsum = 0;
//         sum of full array
        for(int i=0;i<nums.length;i++)
            totalsum+=nums[i];
        
//         innner subarray sum we have to find 
        int findsum = totalsum-x;
        if(findsum==0)
            return nums.length;
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        memo.put(0,-1);
        
        int res=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(memo.containsKey(sum-findsum))
            {
                res=Math.max(res,i-memo.get(sum-findsum));
            }
            memo.put(sum,i);
        }
        return res==Integer.MIN_VALUE? -1:nums.length-res;
        
    }
    
}