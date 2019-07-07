class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m * n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            int[] location = getLocation(mid, n);
            int value = matrix[location[0]][location[1]];
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        int[] startLocation = getLocation(start, n); 
        int[] endLocation = getLocation(end, n);
        if (matrix[startLocation[0]][startLocation[1]] == target
           || matrix[endLocation[0]][endLocation[1]] == target) {
            return true;
        }
        
        return false;
    }
    
    private int[] getLocation(int a, int n) {
        int[] result = new int[2];
        result[0] = a / n;
        result[1] = a % n;
        return result;
    }
}
