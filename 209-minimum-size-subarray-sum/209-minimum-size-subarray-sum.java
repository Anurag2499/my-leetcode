class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int i=0;
        int j=0;
        int res=n+1;
        
        while(j<n)
        {
            target-=nums[j];
            while(target<=0)
            {
                res = Math.min(res,j-i+1);
                target+=nums[i++];
            }
            j+=1;
        }
        return res==n+1?0:res;
        
        
    }
}