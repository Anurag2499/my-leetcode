class Solution {
    public int[] runningSum(int[] nums) {
        int n= nums.length;
        // int[] res = new int[n];
        int x=0;
        for(int i=0;i<n;i++)
        {
            x+=nums[i];
            nums[i]=x;
        }    
        return nums;
    }
}