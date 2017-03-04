import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by flex on 17-2-24.
 * no.90 Subsets II
 * @author flex
 */

public class SubSet {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> subsets, List<Integer> each, int pos, int[] nums) {
        if (pos > nums.length) return;
        subsets.add(each);
        int i = pos;
        while (i < nums.length) {
            each.add(nums[i]);
            helper(subsets, new ArrayList<>(each), i + 1, nums);
            each.remove(each.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i-1]) {   // 去重
                i++;
            }
        }
    }

    // without recursion, just iterator
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;
        for (int i=0; i<nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) begin = 0;
            int size = result.size();
            for (int j=begin; j<size; j++) {
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            // [] [1] [2] [1,2], [2,2], [1,2,2]
            begin = size;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        SubSet subset = new SubSet();
        CombinationSum.printList(subset.subsetsWithDup(nums));
        CombinationSum.printList(subset.subsetsWithDup2(nums));
    }

}
