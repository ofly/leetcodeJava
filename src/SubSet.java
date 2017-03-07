import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by flex on 17-2-24.
 * no.78 Subsets     - without duplicates
 * no.90 Subsets II  - with duplicates
 * @author flex
 */

public class SubSet {

    /* nums中没有重复的数字 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        help(result, item, 0, nums);
        return result;
    }

    private void help(List<List<Integer>> subsets, List<Integer> each, int pos, int[] nums) {
        if (pos > nums.length) return;
        subsets.add(each);
        int i = pos;
        while (i < nums.length) {
            each.add(nums[i]);
            help(subsets, new ArrayList<>(each), i + 1, nums);
            each.remove(each.size() - 1);
            i++;
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num: nums) {
            int len = result.size();
            for (int i=0; i<len; i++) {
                List<Integer> item = new ArrayList<>(result.get(i));
                item.add(num);
                result.add(item);
            }
        }
        return result;
    }


    /* nums中有重复的数字 */
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
                List<Integer> cur = new ArrayList<>(result.get(j));
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
        //CombinationSum.printList(subset.subsetsWithDup(nums));
        //CombinationSum.printList(subset.subsetsWithDup2(nums));
        CombinationSum.printList(subset.subsets2(new int[]{1, 3, 5, 7}));
    }

}
