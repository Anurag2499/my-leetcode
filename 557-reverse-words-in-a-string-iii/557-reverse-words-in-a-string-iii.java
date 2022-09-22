class Solution {
    public String reverseWords(String s) {
        
        char[] ch = s.toCharArray();
        int i=0;
        int j=0;
        while(j<=ch.length)
        {
            if(j==ch.length){
                reverse(ch,i,j-1);
                break;
            }
            if(ch[j]==' '){
                reverse(ch,i,j-1);
                i=j+1;
                
            }
            j++;
            
        }
        String string = new String(ch);
        return string ;
    }
    void reverse(char[] s, int i,int j)
    {
       
        while(i<j)
        {
            char c = s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
        return ;
    }
    
}