/*
Trailing Zeros 
Write an algorithm which computes the number of trailing zeros in n factorial.

Have you met this question in a real interview? Yes
Example
11! = 39916800, so the out should be 2

Challenge
O(log N) time
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        //Example:
        //2, 4, 8, 16,
        //5, 25, 125
        
        //10的个数取决于5和2的个数
        //2的个数远大于5的个数（从5开始差距越来越大）
        //因此只需考虑5的个数。而25包含2个5,125包含3个5
        // Count = float(n/5) + float(n/25) + float(n/125) + .. 直到分子小于分母
        
        if (n < 1) {
            return 0;
        }
        //注意： 此处必须要用长整形防止溢出
        long element = 5;
        long count = 0;
        while(n/element >= 1) {
            count = count + (long)(n/element);
            element = element * 5;
        }
        return count;
        
    }
};

