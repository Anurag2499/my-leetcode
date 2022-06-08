class Solution {
    public int removePalindromeSub(String s) {
        
        int i=0;
        int j= s.length()-1;
        if(isPalindrome(i,j,s))
            return 1;
        return 2;   
    }
    private boolean isPalindrome(int i, int j, String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i+=1;
            j-=1;
        }
        return true;
    }
}