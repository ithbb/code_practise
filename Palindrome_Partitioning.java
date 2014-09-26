/*

Given a string s, partition s such that every substring of the partition is a palindrome. 

Return all possible palindrome partitioning of s. 

For example, given s = "aab",
Return 

  [
    ["aa","b"],
    ["a","a","b"]
  ]

*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> partitionStrs = new ArrayList<String>();
        partitioning(s, 0, partitionStrs, result);
        
        return result;
    }
    
    private void partitioning(String s, int start, ArrayList<String> partitionStrs, ArrayList<ArrayList<String>> result) {
        
        if(start == s.length()) {
            //complete
            ArrayList<String> subResult = new ArrayList<String>(partitionStrs);
            result.add(subResult);
            return;
        } else {
            for(int i = start + 1; i <= s.length(); i++) {
             String subString = s.substring(start, i);
             if (isPalindorme(subString)) {
                 partitionStrs.add(subString);
                 partitioning(s, i, partitionStrs, result);
                 
                 // why move
			     partitionStrs.remove(partitionStrs.size() - 1);

                 
             }
             /*else {
                 start ++;
                 partitioning(s, start, new ArrayList<String>(), result);
             }*/
            }
            
        }
            
    }
    
    private boolean isPalindorme(String s) {
        
        if (s == null || s.length() ==0) return false;
        int i  = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
