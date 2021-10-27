class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int count[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            count[val]++;
        }
        int p = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 1; j <= count[i]; j++) {
                nums[p] = i;
                p++;
            }
        }
    }
}
