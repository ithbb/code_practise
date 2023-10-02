Class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> charSet = new Set<Character>();
    int maxLength = 0;
    int start = 0, end = 0;
    for (int end = 0; end <s.length();) {
      if (!charSet.contians(s.charAt(end)) {
         charSet.add(s.charAt(end);
         end++;
        maxLength = Math.max(maxLength, end - start);
      } else {
        charSet.remove(s.charAt(start));
        start++;
    }
    return maxLength;
  }    
}

