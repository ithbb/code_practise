/*
Fibonacci Show result 

31% Accepted
Find the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

Have you met this question in a real interview? Yes
Example
Given 1, return 0

Given 2, return 1

Given 10, return 34
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {

        
       if (n <= 0) {
            return 0;
        }
        
        if (n == 1) {
            return 0;
        }
        
        if (n == 2) {
            return 1;
        }

/*         
        // Recursion method may cause time limit issue.
        
        return fibonacci(n-2) + fibonacci(n-1);
*/

  
        //定义状态变量
        int[] f = new int[n + 1];
        
        //初始化
        f[0] = 0;
        f[1] = 0;
        f[2] = 1;
        
        //循环递推
        for (int i = 3; i < n + 1; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        
        //返回结果
        return f[n];
    }
}


