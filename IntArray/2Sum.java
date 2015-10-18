/*
2 Sum Show result 

27% Accepted
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

Have you met this question in a real interview? Yes
Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]

Note
You may assume that each input would have exactly one solution
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            hashmap.put(numbers[i], i);
        }
        
        int[] sumNums = new int[2];
        
        for(int i = 0; i< numbers.length; i++) {
            int val = target - numbers[i];
            if(hashmap.containsKey(val)) {
                sumNums[0] = i + 1;
                sumNums[1] = hashmap.get(val) + 1;
                return sumNums;
            }
        }
        return null;
    }
}
