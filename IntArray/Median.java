/*
Median 
Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Have you met this question in a real interview? Yes
Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5

Challenge
O(n) time.
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        //找到排序后第n/2个数
        //等效于将n个数按一个pivot分成两部分，一部分小于pivot，一部分大于pivot。
        //如果刚好划分是n/2, n/2则找到median 否则median在左边或者右边
        //int mid = helper(nums, 0, nums.length - 1, (nums.length + 1)/2);
        
        int k = nums.length%2 == 0 ? nums.length/2-1 : nums.length/2;  
        return helper(nums, 0, nums.length-1, k);
        
    }
    
/*    private int helper(int[] nums, int start, int end, int size) {
        
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        
        int i = start - 1;
        int j = end + 1;
        for(int p = start; p < j; k++) {
            if(nums[p] < pivot) {
                i++;
                swap(nums, i, p);
            } else if (nums[p] > pivot){
                j--;
                swap(nums, j, p);
                k--;
            }
            
        }
        if (i -(start-1) >= size) {
            return helper(nums, start, i, size);
        }
        //
    }*/
    
    
    private int helper(int[] nums, int left, int right, int k) {
           int pivot = right;  
            int num = nums[pivot];  
            int low = left, high = right;  
              
            while (low < high) {  
                while (low < high && nums[low] < num) {  
                    low++;  
                }  
                while (low < high && nums[high] >= num) {  
                    high--;  
                }  
                swap(nums, low, high);  
            }  
            swap(nums, low, right);  
          
            if (low == k) {  
                return nums[low];  
            } else if (low < k) {  
                return helper(nums, low+1, right, k);  
            } else {  
                return helper(nums, left, low-1, k);  
            }  
    }
    
    void swap(int[] num, int left, int right) {  
        int tmp = num[left];  
        num[left] = num[right];  
        num[right] = tmp;  
    }    
    
}
        
        
        
