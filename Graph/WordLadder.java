//TOBEDONE
//
//

/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Have you met this question in a real interview? Yes
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        hash.add(start);
        queue.offer(start);
        
        int length = 1;
        while(!queue.isEmpty()) {
            
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    // Already visited before
                    if(hash.contains(nextWord)) {
                        continue;
                    }
                    
                    if (nextWord == end) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return length;
    }
    
    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        
        ArrayList<String> list = new ArrayList<String>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            for (char j = 'a'; j < 'z'; j++) {
                if (j == c) continue;
                String word2 = replace(word, i, j);
                if (dict.contains(word2)) {
                    list.add(word2);
                }
            }
        }
        return list;
    }
    
    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
