package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-3-18.
 * no.228 Summary Ranges
 * @author flex
 */

/* Problem: Given a sorted integer array without duplicates, return the summary
 * of its ranges. For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {

    private List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        if (nums.length == 0) return results;
        int pre = 0, cur = 1, begin = nums[0];
        while (cur < nums.length) {
            if (nums[cur]-1 > nums[pre]) {
                if (nums[pre] == begin) results.add("" + begin);
                else results.add(begin + "->" + nums[pre]);
                begin = nums[cur];
            }
            pre++;
            cur++;
        }
        if (nums[pre] == begin) results.add("" + begin);
        else results.add(begin + "->" + nums[pre]);
        return results;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        System.out.println(sr.summaryRanges(new int[] {-2147483648,-2147483647,2147483647}).toString());
    }

}
