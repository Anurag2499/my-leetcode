class Solution {
    public int minMoves2(int[] nums) {
        // return 0;
        Arrays.sort(nums);
        int mid=nums.length/2;
        
        int ans=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(i<mid)
        //         ans+= nums[mid]-nums[i];
        //     if(i>mid)
        //         ans+= nums[i]-nums[mid];
        // }
        int i=0,j=nums.length-1;
        while(i<j)
        {
            ans+= nums[j]-nums[i];
            j--;
            i++;
        }
        return ans;
    }
}
// so what we are doing is lets say nums[mid] = C
//  C-nums[0] + C-nums[1] + C-nums[2]......+ C-nums[mid-1] + nums[mid+1]-C + nums[mid+2]-C +......nums[n-1]-C
//  so here all the C's will cancel each other
//  nums[n-1]-nums[0] + nums[n-2]-nums[1]..... nums[mid+1]-nums[mid-1]