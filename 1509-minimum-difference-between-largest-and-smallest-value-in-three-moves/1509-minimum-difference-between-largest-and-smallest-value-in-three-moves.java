class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        
        int n=nums.length;
        if(n<=4)
            return 0;
        
        int p = nums[n-4]-nums[0];
        int q = nums[n-1]-nums[3];
        int r = nums[n-3]-nums[1];
        int s = nums[n-2]-nums[2];
        int a=(r<s?r:s);
        int b= (p<q?p:q);
            
        return a<b?a:b;
        
        
        
    }
}