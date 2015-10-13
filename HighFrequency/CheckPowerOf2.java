/*
O(1) Check Power of 2

26% Accepted
Using O(1) time to check whether an integer n is a power of 2.

Have you met this question in a real interview? Yes
Example
For n=4, return true;

For n=5, return false;

Challenge
O(1) time
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
       
       if (n < 1) {
           return false;
       }
       
       if(n == 1 || n == 2) {
           return true;
       } else {
           int x= (n-1)&n;
           return x == 0;
       }
    }
};
