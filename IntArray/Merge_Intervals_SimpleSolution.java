class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        
        Arrays.sort(intervals, (v0, v1) -> v0[0] - v1[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
          if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < intervals[i][0]) {
              merged.add(intervals[i]);
          }  else {
              int[] newMerge = merged.get(merged.size() - 1);
              newMerge[1] = Math.max(newMerge[1], intervals[i][1]);
          }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
