/*
Merge Intervals Show result 

19% Accepted
Given a collection of intervals, merge all overlapping intervals.

Have you met this question in a real interview? Yes
Example
Given intervals => merged intervals:

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]
Challenge
O(n log n) time and O(1) extra space.

*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, new IntervalComparator());
        
        int size = intervals.size();
        result.add(intervals.get(0));
        Interval last = result.get(0);
        
        for (int i = 1; i < size; i++) {
            
            Interval tmp = intervals.get(i);
            if (tmp.start <= last.end ) { //&& tmp.end >= last.start
                //last.start = Math.min(intervals.get(i).start, last.start);
                last.end = Math.max(intervals.get(i).end, last.end);
            } else {
                result.add(intervals.get(i));
                last = result.get(result.size() - 1);
            }
            
        }
        
        return result;
        
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval interval1, Interval interval2) {
            if (interval1.start > interval2.start) {
                return 1;
            } else if (interval1.start < interval2.start) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
