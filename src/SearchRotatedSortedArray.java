/**
 * Created by flex on 17-3-4.
 * no.33 Search in Rotated Sorted Array
 * no.81 Search in Rotated Sorted Array II
 */

/* Problem: Suppose an array sorted in ascending order is rotated at some pivot
 * unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * Note: The array may contain duplicates.
 *
 * Problem: Search the target, if found in the array return its index,
 * otherwise return -1.
 */
public class SearchRotatedSortedArray {
    // 二分法搜索： 3 4 5 6 0 1 2
    private int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        if (target == nums[l]) return l;
        if (nums[l] >= nums[r]) {
            if (target < nums[l]) {
                while (l < r && nums[l+1] >= nums[l++]);
            } else {
                while (l < r && nums[r] >= nums[r-1]) r--;
            }
        }
        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] == target) return m;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return (nums[l] == target)?l:-1;
    }

    // 二分法搜索
    private boolean searchII(int[] nums, int target) {
        return search(nums, target) != -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray rsa = new SearchRotatedSortedArray();
        System.out.println(rsa.search(new int[]{1}, 0));
        System.out.println(rsa.search(new int[]{1,1,1}, 1));
        System.out.println(rsa.search(new int[]{3,4,5,0,1,2}, 0));
        System.out.println(rsa.searchII(new int[]{1}, 0));
        System.out.println(rsa.searchII(new int[]{1,1,1}, 1));
        System.out.println(rsa.searchII(new int[]{3,4,5,0,1,2}, 0));
    }

}
