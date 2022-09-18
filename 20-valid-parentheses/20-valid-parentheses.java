class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        int n=s.length(),i=0;
        while(i<n)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') st.push(s.charAt(i));
            else if(!st.isEmpty()){
                boolean flag = compare(s.charAt(i),st.peek());
                if(flag) st.pop();
                else return false;
            }
            else return false;
            i++;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
    boolean compare(Character a,Character b){
        if((a==')' && b=='(' )||( a=='}' && b=='{' ) || (a==']' && b=='[')) return true;
        else return false;
    }
}