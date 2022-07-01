class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int l=0;
        int h= n-1;
        
        
        
        while(l<=h)
        {
            int mid =l+ (h-l)/2;
            if(nums[l]<=nums[h])
            return nums[l];
            
            int nextIndex= (mid+1)%n;
            int prevIndex = (mid-1+n)%n;
            
            if(nums[mid]<=nums[nextIndex] && nums[mid]<=nums[prevIndex])
                return nums[mid];
            
            else if(nums[mid]>=nums[l])
                l=mid+1;
            else
                h=mid-1;
        }
        return 0;
    }
}