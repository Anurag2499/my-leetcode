class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums,0,new ArrayList<Integer>(),ans);
        
        int res=0;
        for(List<Integer> row:ans){
            int temp=0;
            for(int val : row )
            {
                temp^=val;
            }
            res+=temp;
        }
        return res;
        
    }
    private void subsets(int[] nums, int ci,ArrayList<Integer> currentset, List<List<Integer>> ans)
    {
        if(ci>=nums.length)
        {
            ans.add(new ArrayList(currentset));
            return ;
        }
        
        currentset.add(nums[ci]);
        subsets(nums,ci+1,currentset,ans);
        currentset.remove(currentset.size()-1);
        subsets(nums,ci+1,currentset,ans);
        return ;
        
    }
}