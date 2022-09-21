class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int evensum = sumation(nums,n);
        
        for(int i=0;i<n;i++)
        {
            int initialval = nums[queries[i][1]];
            int addval= queries[i][0];
            
            
            if(Math.abs(initialval)%2==1){
                if(Math.abs(addval)%2==1){
                    evensum+= (initialval+addval);
                }
            }
            else{
                if(Math.abs(addval)%2==1){
                    evensum-=initialval;
                }
                else{
                    evensum+=addval;
                }
            }
            System.out.println(evensum);
            nums[queries[i][1]] = nums[queries[i][1]]+ queries[i][0];
            ans[i]=evensum;
        }
        return ans;
    }
    
    public int sumation(int[] nums,int n )
    {
        int a =0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==0) a+=nums[i];
        }
        return a;
    }
}