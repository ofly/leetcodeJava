/**
 * Created by flex on 17-3-4.
 * no.81 Search in Rotated Sorted Array II
 */

public class RotatedSortedArray {
    // 3 4 5 6 0 1 2
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int l = 0, r = nums.length-1;
        if (target == nums[l]) return true;
        if (nums[l] >= nums[r]) {
            if (target < nums[l]) {
                while (l < r && nums[l+1] >= nums[l++]);
            } else {
                while (l < r && nums[r] >= nums[r-1]) r--;
            }
        }
        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] == target) return true;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return nums[l] == target;
    }

    public static void main(String[] args) {
        RotatedSortedArray rsa = new RotatedSortedArray();
        System.out.println(rsa.search(new int[]{1}, 0));
    }

}
