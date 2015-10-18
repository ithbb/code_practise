/*
Longest Consecutive Sequence Show result 

33% Accepted
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Have you met this question in a real interview? Yes
Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.
*/

//由O（n）想到 Hash方法

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        
        if (num == null || num.length == 0) {
            return 0;
        }        
        
        //set保存每个Unique数值
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int n : num) {
            set.add(n);
        }
        
        int totalMax = 1;
        
        // 对每个数值依次查找 num[i]+1, num[i] + 2 ...
        // num[i]-1, num[i]-2
        for(int i = 0; i < num.length; i++) {
            
            int iMax = 1;
            
            if (set.contains(num[i])) {
                //对于每一个已经找个的元素，踢出set以避免重复查找
                set.remove(num[i]);
                
                int tmp = num[i];
                while(set.contains(--tmp)) {
                    iMax++;
                    set.remove(tmp);
                }
                
                tmp = num[i];
                while(set.contains(++tmp)) {
                    iMax++;
                    set.remove(tmp);
                }
            }
            // 比较 取最大值
            totalMax = Math.max(iMax, totalMax);
        }
        return totalMax;
    }
}
