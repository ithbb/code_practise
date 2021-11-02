class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int mod = 0;
        while (y > 0) {
            mod = mod * 10 + y % 10;
            y = y / 10;
        }
        
        return mod == x;
    }
}
