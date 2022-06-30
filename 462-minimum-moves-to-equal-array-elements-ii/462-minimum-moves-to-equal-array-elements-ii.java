class Solution {
    public int minMoves2(int[] nums) {
        // return 0;
        Arrays.sort(nums);
        int mid=nums.length/2;
        
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i<mid)
                ans+= nums[mid]-nums[i];
            if(i>mid)
                ans+= nums[i]-nums[mid];
        }
        return ans;
    }
}