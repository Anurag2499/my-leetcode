class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<nums2.length;i++)
        {
            while(!st.isEmpty() && nums2[i]>st.peek())
            {
                map.put(st.peek(),nums2[i]);
                st.pop();
            }
            st.push(nums2[i]);
        }
        
        int[] ans = new int[nums1.length];
        for(int i =0;i<nums1.length;i++){
            if(map.containsKey(nums1[i]))
                ans[i]=map.get(nums1[i]);
            else
                ans[i]=-1;
        }
        return ans;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // int[] ans = new int[nums1.length];
        // for(int i=0;i<nums1.length;i++)
        // {
        //     int ele = nums1[i];
        //     int index=0;
        //     for(int j=0;j<nums2.length;j++)
        //     {
        //         if(nums2[j]==ele){
        //             index=j;
        //             break;
        //         }
        //     }
        //     int flag=0;
        //     for(int j=index+1;j<nums2.length;j++)
        //     {
        //         if(nums2[j]>ele)
        //         {
        //             ans[i]=nums2[j];
        //             flag=1;
        //             break;
        //         }
        //     }
        //     if(flag==0) ans[i]=-1;
        // }
        // return ans;
    }
}