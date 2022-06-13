class Solution {
    public int numDecodings(String s) {
        int ans=0;
        ans = decode(s,0,new HashMap<Integer,Integer>());
        return ans;
    }
    private int decode(String s, int ci,HashMap<Integer,Integer> memo)
    {
        if(ci==s.length())
            return 1;
        
        if(s.charAt(ci)=='0')
            return 0;
        
        if(ci==s.length()-1)
            return 1;
        
        if(memo.containsKey(ci))
            return memo.get(ci);
        
        String st = s.substring(ci,ci+2);
        
        int way1 = decode(s,ci+1,memo);
        
        int way2=0;
        int val = Integer.parseInt(st);
        if(val<=26 && val>0)
            way2=decode(s,ci+2,memo);
        
        memo.put(ci,way1+way2);
        
        
        return way1+way2;
        
    }
}