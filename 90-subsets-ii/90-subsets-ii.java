class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        sset(nums,0,new ArrayList<Integer>(),ans);    
        List res = new ArrayList(ans);
        return res;
    }
    private void sset(int[] nums, int ci,List<Integer> currentsubset, Set<List<Integer>> ans)
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