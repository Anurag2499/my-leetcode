//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here4A
        ArrayList<ArrayList<String>> ans= new ArrayList<>();
        ArrayList<String> curr= new ArrayList<>();
        
        palin(S,0,curr,ans);
        return ans;
    }
    
    static boolean ispalin(String s){
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
            
        }
        return true;
    }
    
    static void  palin(String S, int ci, ArrayList<String> curr, ArrayList<ArrayList<String>> ans)
    {
        if(ci==S.length()){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        
        
        for(int i=ci;i<S.length();i++){
            String newsub = S.substring(ci,i+1);
            
            if(ispalin(newsub)){
                curr.add(newsub);
                palin(S,i+1,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
        
    }
};