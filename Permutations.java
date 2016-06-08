/*Given a list of numbers, return all possible permutations.
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For nums = [1,2,3], the permutations are:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
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







// 规范解
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
            
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(nums);  
        permuteHelper(result, list, nums);

        return result;
    }


    private void permuteHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, ArrayList<Integer> nums) {

        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            
            if(list.contains(nums.get(i))){
                continue;
            }

            list.add(nums.get(i));
            permuteHelper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
    
}



