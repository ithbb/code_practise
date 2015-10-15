/*
Longest Words
Given a dictionary, find all of the longest words in the dictionary.

Have you met this question in a real interview? Yes
Example
Given

{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        
        ArrayList<String> result = new ArrayList<String>();
        
        if (dictionary == null  || dictionary.length == 0) {
            return result;
        }
        
        int maxLength = 0;
        
        for(int i = 0; i < dictionary.length; i++) {
            String str = dictionary[i];
            if (str.length() > maxLength) {
                maxLength = str.length();
                result.clear();
                result.add(str);
            } else if (str.length() == maxLength) {
                result.add(str);
            }
        }
        return result;
    }
}
