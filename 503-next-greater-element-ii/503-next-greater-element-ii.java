class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        
        int n= nums.length;
        
        for(int i=0;i<n;i++)
        {
            int k=n;
            int j=(i+1)%n;
            while(k>0)
            {
                if(nums[j]>nums[i])
                {
                    ans[i]=nums[j];
                    break;
                }
                else{
                    j=(j+1)%n;
                    k--;
                }
            }
            if(k==0) ans[i]=-1;
        }
        return ans;
    }
}