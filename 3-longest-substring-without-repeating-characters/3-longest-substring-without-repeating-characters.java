class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> memo = new HashMap<>();
        int ans=0;
        
        int rel=0;
        int acq=0;
        while(acq<n)
        {
            while(rel<=acq && memo.containsKey(s.charAt(acq)))
            {
                memo.remove(s.charAt(rel));
                rel+=1;
            }
            memo.put(s.charAt(acq),1);
            ans = Math.max(ans,(acq-rel+1));
            acq+=1;
        
        }
        return ans;
    }
}