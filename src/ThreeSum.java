import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by flex on 17-3-1.
 * no.15 3Sum
 * @author flex
 */

public class ThreeSum {
    // [-1, 0, 1, 2, -1, -4]
    // [[-1, 0, 1], [-1, -1, 2]]
    // O(n^3) - time limit
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i> 0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<nums.length-1; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                int n = nums.length - 1;
                while (n > j+1 && nums[i]+nums[j]+nums[n] > 0) n--;
                if (nums[i]+nums[j]+nums[n] == 0) res.add(Arrays.asList(nums[i], nums[j], nums[n]));
            }
        }
        return res;
    }

    // O(n^2)
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}