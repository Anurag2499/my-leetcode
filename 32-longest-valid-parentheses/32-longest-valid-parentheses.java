class Solution {
    public int longestValidParentheses(String S) {
                Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='(') st.push(i);
            else {
                if(!st.isEmpty() && S.charAt(st.peek())=='(')
                {   
                    st.pop();
                }
                else
                {
                    st.push(i);
                }
            }
        }
        
        int res=S.length();
        if(st.isEmpty()) return res;
        int prev = st.isEmpty()?0:st.pop();
        res= res-prev-1;
        
        while(!st.isEmpty())
        {
            res = Math.max(res, prev-st.peek()-1);
            prev = st.pop();
        }
        res = Math.max(res,prev);
        return res;
        
    
    }
}