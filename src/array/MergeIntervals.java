package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-3-13.
 * no.56 Merge Intervals
 * @author flex
 */

/* Problem: Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        // 用于方法引用
        /*
        int getStart() {
            return start;
        }
        */
    }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> results = new ArrayList<>();
        if (intervals.size() == 0) return results;
        // Sort by ascending starting point using an anonymous Comparator
        /*
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        */
        // lambda表达式
        // intervals.sort((i1, i2) -> i1.start - i2.start);
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        // 方法引用
        // intervals.sort(Comparator.comparingInt(Interval::getStart));
        results.add(intervals.remove(0));
        while (intervals.size() > 0) {
            Interval i1 = results.get(results.size()-1);
            Interval i2 = intervals.remove(0);
            if (i1.end >= i2.start) {
                i1.end = Math.max(i1.end, i2.end);
            } else {
                results.add(i2);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(3, 5));
        List<Interval> results = mi.merge(intervals);
        for (Interval interval: results) {
            System.out.printf("[%d,%d]\n", interval.start, interval.end);
        }
    }

}
