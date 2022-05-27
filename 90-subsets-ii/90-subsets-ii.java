class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        sset(nums,0,new ArrayList<Integer>(),ans);
        

        
        return ans;
    }
    private void sset(int[] nums, int ci,List<Integer> currentsubset, List<List<Integer>> ans)
    {
        if(ci >= nums.length)
        {
            if(!ans.contains(currentsubset)){
            ans.add(new ArrayList<>(currentsubset));}
            return ;
        }
        
        currentsubset.add(nums[ci]);
        sset(nums,ci+1,currentsubset,ans);
        
        currentsubset.remove(currentsubset.size()-1);
        sset(nums,ci+1,currentsubset,ans);
        return ;
    }
}