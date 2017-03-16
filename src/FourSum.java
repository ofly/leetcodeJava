import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by flex on 17-3-16.
 * no.18 4Sum
 * @author flex
 */

public class FourSum {
    // Four sum
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1, r = nums.length-1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                        while (l < r && nums[l] == nums[l-1]) l++;
                        while (l < r && nums[r] == nums[r+1]) r--;
                    }
                    if (sum > target) r--;
                    if (sum < target) l++;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        System.out.println("four sum:");
        System.out.println(fs.fourSum(new int[]{1,1,1,1}, 4));
        System.out.println(fs.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fs.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(fs.fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7));
    }
}
