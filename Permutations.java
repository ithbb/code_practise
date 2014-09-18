/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return null;
        }
        
        if (num.length == 0) {
            return retList;
        }
   
        retList = getPermutation(num, 0);

        return retList; 
    }
    
    
    private ArrayList<ArrayList<Integer>> getPermutation(int[] num, int index) {
        
        int size = num.length;
        
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> remainList;
        if(index < size - 1) {
          remainList = getPermutation(num, index + 1);
          for(ArrayList<Integer> list : remainList) {
              
              for(int i = 0; i <= list.size(); i++) {
                  ArrayList<Integer> newList = new ArrayList<Integer>();
                  newList.addAll(list);
                  newList.add(i, num[index]);
                  retList.add(newList);
              }
              
          }
        } else if (index == size -1) {
            ArrayList<Integer> subList = new ArrayList<Integer>();
            subList.add(new Integer(num[index]));
            retList.add(subList);
        }
        return retList;
    }
}
