class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = llcs(word1,word2,0,0,new HashMap<String,Integer>());
        return (word1.length()-lcs) + (word2.length()-lcs);
    }
    private int llcs(String w1,String w2, int i,int j, HashMap<String,Integer> memo)
    {
        if(i>=w1.length() || j>=w2.length())
            return 0;
        
        String currentKey = i+"-"+j;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int ans=0;
        if(w1.charAt(i)==w2.charAt(j))
            ans = 1+llcs(w1,w2,i+1,j+1,memo);
        else
        {
            ans = Math.max(llcs(w1,w2,i+1,j,memo),llcs(w1,w2,i,j+1,memo));
        }
        
        memo.put(currentKey,ans);
        return ans;
        
        
    }
}