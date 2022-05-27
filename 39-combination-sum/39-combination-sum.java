class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinations(candidates, target, 0,new ArrayList<Integer>(),ans);
        return ans;
    }
    private void combinations(int[] candidates, int target, int ci,ArrayList<Integer> currentsubset, List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList(currentsubset));
            return;
        }
        
        if(ci>=candidates.length)
            return ;
        
        if(target<0)
            return;
        
        

        if(target>=candidates[ci])
        {
        currentsubset.add(candidates[ci]);
        combinations(candidates, target-candidates[ci],ci,currentsubset,ans);
        currentsubset.remove(currentsubset.size()-1);
        }
        
        combinations(candidates, target,ci+1,currentsubset, ans);
        return ;
    }
}