class Solution {
    public String reverseWords(String s) {
        String ans = "";
        Stack<String> st = new Stack<>();

        int n = s.length();
        int i = 0;
        while (i < n) {
            String temp = "";
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < n && s.charAt(i) != ' ') {
                temp += s.charAt(i);
                i++;
            }
            st.add(temp);
            i++;
        }
        while (st.size() != 0) {
            ans += st.pop();
            if (st.size() != 0)
                ans += " ";
        }
        return ans;
    }
}