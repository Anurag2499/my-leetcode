class Solution {
    public String pushDominoes(String dominoes) {
       
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        
        int rightindex=-1;
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R')
            {
                rightindex = i;
            }
            else if(dominoes.charAt(i)=='L'){
                rightindex = -1;
            }
            right[i]=rightindex;
        }
        
        int leftindex=-1;
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L')
            {
                leftindex = i;
            }
            else if(dominoes.charAt(i)=='R'){
                leftindex = -1;
            }
            
            left[i]=leftindex;
        }
        
        char[] ans = new char[n];
        for(int i=0;i<n;i++)
        {
            if(dominoes.charAt(i)=='.'){
                int leftdiff= left[i]==-1? Integer.MAX_VALUE : Math.abs(left[i]-i);
                int rightdiff= right[i]==-1? Integer.MAX_VALUE : Math.abs(right[i]-i);
                
                if(leftdiff==rightdiff) ans[i]='.';
                else if(leftdiff>rightdiff) ans[i]= 'R';
                else ans[i] = 'L';
            }
            else{
                ans[i] =dominoes.charAt(i);
            }
        }
        return new String(ans);
    }
}









