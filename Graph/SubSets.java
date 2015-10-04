/*
Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Note
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.
*/



class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        
        if (S == null || S.size() == 0) {
            return resultList;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);
        subSetsHelper(resultList, list, S, 0);
        
        return resultList;
    }
    
    private void subSetsHelper(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {
        
        resultList.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < S.size(); i++) {
            list.add(S.get(i));
            subSetsHelper(resultList, list, S, i+1);
            list.remove(list.size() - 1);
        }
         
    }
}
