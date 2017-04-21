package array;

/**
 * Created by flex on 17-2-21.
 * no.34
 * @author flex
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] results = new int[2];
        results[0] = findFirstEqual(nums, target);
        results[1] = findLastEqual(nums, target);
        return results;
    }

    public int findFirstEqual(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public int findLastEqual(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
        for (int num : sr.searchRange(nums, 4)) {
            System.out.println(num);
        }
        for (int num : sr.searchRange(nums, 3)) {
            System.out.println(num);
        }
    }
}
