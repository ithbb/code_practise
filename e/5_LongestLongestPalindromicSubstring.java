class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <=1) {
            return s;
        }
        boolean[][] p = new boolean[length][length];
        String longestStr = s.substring(0, 1);
        for (int j = 0; j <length; j++) {
            for (int i = 0; i < j; i++) {
                 if (i == j) {
                     p[i][j] = true;
                 }else {
                     if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || p[i+1][j-1] == true)) {
                        longestStr = s.substring(i, j+1);
                     }
                 }
            }
        }
        return longestStr;
    }
}
