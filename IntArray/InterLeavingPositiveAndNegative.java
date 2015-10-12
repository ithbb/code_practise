/*
Interleaving Positive and Negative Numbers  

20% Accepted
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

Have you met this question in a real interview? Yes
Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Note
You are not necessary to keep the original order of positive integers or negative integers.
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        
        if (A == null || A.length == 0) {
            return;
        }
        
        int len = A.length;
        
        
        int negMod = 0;
        int posMod = 1;
        
        //首先统计正数和负数的个数以决定先排正数还是负数
        //对于奇数个数字需要计算，偶数则不需要
        if (len % 2 == 1) { 
            int numPos = 0;
            int numNeg = 0;
            for(int i = 0; i < len; i++) {
                if (A[i] > 0) {
                    numPos++;
                } else {
                    numNeg++;
                }
            }
            //如正数多，交换顺序
            if (numPos > numNeg) {
               negMod = 1;
               posMod = 0;
            }
        }
        
        for (int i = 0; i < len; i++) {
            
            //默认负数优先
            //如果正数多，则正数优先
            if ((i % 2 == negMod && A[i] > 0) ||
                //正数
                (i % 2 == posMod && A[i] < 0)) {
                
                int p = i + 1;
                while(p < len && A[p]*A[i] > 0) {
                    p++;
                }
                
                int tmp = A[i];
                A[i] = A[p];
                A[p] = tmp;
            }
            
        }
   }
}
