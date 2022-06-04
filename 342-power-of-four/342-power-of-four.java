class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)
            return true;
        
        if(n<1)
            return false;
        
        return (n%4==0) && isPowerOfFour(n/4);
    }
}