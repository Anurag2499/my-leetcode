class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        for(int i=0;i<=nums.length;i++)
        {
            memo.put(i,1);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(memo.containsKey(nums[i]))
            {
                memo.put(nums[i],0);
            }
        }
        for(int i=0;i<=nums.length;i++)
        {
            if(memo.get(i)==1)
                return i;
        }
        return 0;
    }
}