class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        
        
        int start=0;
        int max_len=1;
        
        int l=0;
        int r=0;
        
        for(int i=1;i<n;i++)
        {
            //even 
            l=i-1;
            r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>max_len)
                {
                    max_len=r-l+1;
                    start=l;
                }
                l-=1;
                r+=1;
            }
            
            //odd
            l=i-1;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>max_len)
                {
                    max_len=r-l+1;
                    start=l;
                }
                l-=1;
                r+=1;
            }
        }
        return s.substring(start,start+max_len);
        
        
        
        
        // String ans ="";
        // int a=0;
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=i;j<n;j++)
        //     {
        //         int temp=0;
        //         if(isPalin(s,i,j))
        //            {
        //             temp = j-i+1;
        //             if(temp > a)
        //                 ans=s.substring(i,j+1);
        //             a=Math.max(a,temp);
        //            }               
        //     }
        // }
        // return ans;
    }
    
    // private boolean isPalin(String s,int i,int j)
    // {
    //     while(i<=j)
    //     {
    //         if(s.charAt(i)!=s.charAt(j))
    //             return false;
    //         i+=1;
    //         j-=1;
    //     }
    //     return true;
    // }   
}