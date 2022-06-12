class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int i=0;
        int j=0;
        int res=0;
        int sum=0;
        
        while(j<nums.length)
        {
            if(memo.containsKey(nums[j]))
            {
                while(memo.containsKey(nums[j]))
                {
                    memo.remove(nums[i]);
                    sum-=nums[i];
                    i+=1;
                }
            }
            memo.put(nums[j],1);
            sum+=nums[j];
            res=Math.max(res,sum);
            
            j+=1;
        }
        return res;
    }
}