/*Merge Two Sorted Arrays */
/*Merge two given sorted integer array A and B into a new sorted integer array.*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        
        if (A == null && B == null) {
            return null;
        }
        if (A.length == 0) {
            return B;
        }
        if (B.length == 0) {
            return A;
        }
        
        int sa = A.length;
        int sb = B.length;
        int s = sa + sb;
        int p = 0, q = 0;
        int[] C = new int[s];
        int i = 0;
        for (; i < s &&  p < sa && q < sb; i++) {
            if(A[p] < B[q]) {
                C[i] = A[p];
                p++;
            } else {
                C[i] = B[q];
                q++;
            }
        }
        
        
        while (p < sa) {
            C[i++] = A[p++];
        }
        
        while (q < sb) {
           C[i++] = B[q++];   
        }
        return C;
    }
}

