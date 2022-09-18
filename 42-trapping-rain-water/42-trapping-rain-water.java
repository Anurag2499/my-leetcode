class Solution {
    public int trap(int[] arr) {
        int l=0;
        int r=arr.length-1;
        int leftmax=arr[0];
        int rightmax=arr[r];
        int ans=0;
        while(l<=r)
        {
            if(arr[l]<=arr[r]){
                if(arr[l]>=leftmax) leftmax=arr[l];
                else ans+= leftmax-arr[l];
                l++;
            }
            else{
                if(arr[r]>=rightmax) rightmax= arr[r];
                else ans+= rightmax-arr[r];
                r--;
            }
        }
        return ans;
    }
}