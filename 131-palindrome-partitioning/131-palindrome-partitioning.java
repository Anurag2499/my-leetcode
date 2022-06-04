class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        allcombs(s,0,s.length()-1,new ArrayList<String>(), res);
        return res;
    }
    private void allcombs(String s, int start,int end,ArrayList<String> currentconf, List<List<String>> res )
    {
        if(start>end)
            res.add(new ArrayList<String>(currentconf));
        
        for(int i=start;i<=end;i++)
        {
            String leftpart = s.substring(start,i+1);
            if(isPalindrome(leftpart))
            {
                currentconf.add(leftpart);
                allcombs(s,i+1,end,currentconf,res);
                currentconf.remove(currentconf.size()-1);
            }
        }
        return ;
    }
    
    private boolean isPalindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i+=1;
            j-=1;
        }
        return true;
    }
}