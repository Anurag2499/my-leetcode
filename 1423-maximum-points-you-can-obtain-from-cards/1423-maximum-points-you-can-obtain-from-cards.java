class Solution {
    public int maxScore(int[] nums, int k) {
        
        int total=0;
        
        for(int i=0;i<k;i++)
            total+=nums[i];
        
        int maxsum=total;
        
        for(int i=k-1,j=nums.length-1;i>=0;i--,j--)
        {
            total+= nums[j]-nums[i];
            
            maxsum = Math.max(total,maxsum);
        }
        return maxsum;
    }
    
   
    
}