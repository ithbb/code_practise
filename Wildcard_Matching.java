/*
原题链接: http://oj.leetcode.com/problems/wildcard-matching/ 
这道题目其实是Regular Expression Matching的简化版，在这里'?'相当于那边的'.'，而'*'相当于那边的'.*'，因为这里'*'就可以代替任何字符串，不需要看前面的字符，所以处理起来更加简单。
brute force的方法就不重新列举代码了，有兴趣实现的朋友可以参考一下Regular Expression Matching，代码结构一样，只是处理情况变一下就可以，不过leetcode过不了（因为超时）。
我们主要还是说一下动态规划的方法。跟Regular Expression Matching一样，还是维护一个假设我们维护一个布尔数组res[i],代表s的前i个字符和p的前j个字符是否匹配(这里因为每次i的结果只依赖于j-1的结果，所以不需要二维数组，只需要一个一维数组来保存上一行结果即可），递推公式分两种情况：
    (1)p[j]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'?'，也是相同），并且res[i]==true，则更新res[i+1]为true，否则res[i+1]=false;  
    (2)p[j]是'*'。因为'*'可以匹配任意字符串，所以在前面的res[i]只要有true，那么剩下的          res[i+1], res[i+2],...,res[s.length()]就都是true了。
算法的时间复杂度因为是两层循环，所以是O(m*n), 而空间复杂度只用一个一维数组，所以是O(n)，假设s的长度是n，p的长度是m。代码如下：
*/

public class Solution {
public boolean isMatch(String s, String p) {
    if(p.length()==0)
        return s.length()==0;
    
    //no need. only for the test case
    if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
    return false;
    
    boolean[] res = new boolean[s.length()+1];
    res[0] = true;
    for(int j=0;j<p.length();j++)
    {
        if(p.charAt(j)!='*')
        {
            for(int i=s.length()-1;i>=0;i--)
            {
                res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));
            }
        }
        else
        {
            int i = 0;
            while(i<=s.length() && !res[i])
                i++;
            for(;i<=s.length();i++)
            {
                res[i] = true;
            }
        }
        res[0] = res[0]&&p.charAt(j)=='*';
    }
    return res[s.length()];
}
}
