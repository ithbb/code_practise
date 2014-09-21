/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] A, int target) {
        
        if (A == null) {
            return -1;
        }
        
        int length = A.length;
        
        
        
        return binarySearch(A, target, 0, length - 1);
    }
    
    private int binarySearch(int[] A, int target, int left, int right) {
        
         
        while (left <= right) {
            int mid = (left + right) / 2;
            
            
            if (target == A[mid]) {
                return mid;
            }
    
            
            if (A[mid] >= A[left]) {
                //Left is sorted
                if (target < A[mid] && target >= A[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //Right is sorted    
                if (target > A[mid] && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
               
            }
            
        }
        
        return -1;

    }
}
