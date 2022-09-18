class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxl = new int[n];
        int[] maxr = new int[n];
        
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(height[i]>max){
                max= height[i];
                maxl[i]=max;
            }
            else
                maxl[i] = max;
        }
        max=0;
        for(int i=n-1;i>=0;i--)
        {
            if(height[i]>max){
                max= height[i];
                maxr[i]=max;
            }
            else
                maxr[i] = max;
        }
        int min[] =new int[n];
        for(int i=0;i<n;i++){
            min[i] = Math.min(maxl[i],maxr[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            min[i]=min[i]-height[i];
            ans+=min[i];
        }
        return ans;
    }
}