package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by flex on 17-3-1.
 * no.15 3Sum
 * no.16 3Sum Closest
 * @author flex
 */

/* Problem: Given an array S of n integers, are there elements a, b, c in S such that a+b+c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Problem: Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You may assume
 * that each input would have exactly one solution.
 *
 * Problem: Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which gives the
 * sum of target.
 **/

public class ThreeSum {
    // [-1, 0, 1, 2, -1, -4]
    // [[-1, 0, 1], [-1, -1, 2]]
    // Three sum, O(n^3) - time limit
    private List<List<Integer>> threeSum(int[] nums) {
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

    // Three sum, O(n^2)
    private List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                }
                if (sum > 0) r--;
                if (sum < 0) l++;
            }
        }
        return res;
    }

    // Three sum closest, O(n^2)
    private int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE-Math.abs(target);
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                if (sum > target) r--;
                if (sum < target) l++;
                if (Math.abs(sum-target) < Math.abs(res-target)) res = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println("three sum:");
        System.out.println(ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(ts.threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("three sum closest:");
        System.out.println(ts.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(ts.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
        System.out.println(ts.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
        System.out.println(ts.threeSumClosest(new int[]{-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33}, 0));
    }
}