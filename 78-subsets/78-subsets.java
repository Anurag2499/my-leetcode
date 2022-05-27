class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cs = new ArrayList<>();
        sset(nums,0,cs,ans);
        return ans;
    }
    private void sset(int[] nums, int ci,List<Integer> currentsubset, List<List<Integer>> ans)
    {
        if(ci >= nums.length)
        {
            ans.add(new ArrayList<>(currentsubset));
            return ;
        }
        
        currentsubset.add(nums[ci]);
        sset(nums,ci+1,currentsubset,ans);
        
        currentsubset.remove(currentsubset.size()-1);
        sset(nums,ci+1,currentsubset,ans);
        return ;
    }
}