/*

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.



For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

*/


public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (candidates.length == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(result, list, candidates, 0, target);
        
        return result;
    }
    
    
    private void combinationSumHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] candidates, int pos, int target) {
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        
        int pre = -1;
        for (int i = pos; i < candidates.length; i++) {
           
            
            if (candidates[i] > target) {
                break;
            }
            
            if (pre != -1 && pre == target) {
                continue;
            }
            
            list.add(new Integer(candidates[i]));
            combinationSumHelper(result, list, candidates, i, target - candidates[i]);
            list.remove(list.size() - 1);
            pre = candidates[i];
        }
        
    }
}
