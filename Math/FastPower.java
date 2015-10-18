/*
Fast Power Show result 

19% Accepted
Calculate the an % b where a, b and n are all 32bit integers.

Have you met this question in a real interview? Yes
Example
For 231 % 3 = 2

For 1001000 % 1000 = 0

Challenge
O(logn)

Tags Expand  
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        
        if (a == 0){
            return 0;
        }
        
        if (a == 1) {
            return 1 % b;
        }
        
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        
        //取为长整形，避免溢出
        long ret = 0;
        
        /*
        模运算规则
        模运算与基本四则运算有些相似，但是除法例外。其规则如下：
        (a + b) % p = (a % p + b % p) % p （1）
        (a - b) % p = (a % p - b % p) % p （2）
        (a * b) % p = (a % p * b % p) % p （3）
        a ^ b % p = ((a % p)^b) % p （4）
        */
        
        // 对于n是偶数的情况
        // (a^n)%b = (a^(n/2)%p * a(n/2)%p) %p 
        if (n >= 2) {
            ret = fastPower(a, b, n/2);
        }
        ret *= ret;
        
        // 这一步是为了防止溢出
        ret %= b;
        
        // 奇数的情况 还有一个a  
        // (a^n = a^(n/2) * a^(n/2) * a)
        if (n % 2 == 1) {
            ret = ret * a % b;
        }
        ret = ret % b;
        
        return (int)ret;
    }
};
