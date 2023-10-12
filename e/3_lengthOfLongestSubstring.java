class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0;

        while (j < s.length()) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                charSet.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}
