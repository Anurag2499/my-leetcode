class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> memo = new HashSet<>();
        
        int total = 1<<k;
        
        for(int i=0;i<=s.length()-k;i++)
        {
            memo.add(s.substring(i,i+k));
            if(memo.size()==total)
                return true;
        }
        return false;
    }
}