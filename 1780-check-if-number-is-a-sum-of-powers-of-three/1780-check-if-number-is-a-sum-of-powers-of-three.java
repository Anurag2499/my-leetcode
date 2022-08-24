class Solution {
    public boolean checkPowersOfThree(int n) {
        
        while(n>0 && n%3!=2)
        {
            n = n%3==1? n-1 : n/3;
        }
        if(n==0) return true;
        return false;
        
    }
}