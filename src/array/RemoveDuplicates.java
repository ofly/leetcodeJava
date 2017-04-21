package array;

/**
 * Created by flex on 17-3-4.
 * no.80 Remove Duplicates from Sorted Array II
 * @author flex
 */

public class RemoveDuplicates {
    // [1,1,2,1,2,2,3]
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return 2;
        int i = 1, len = 1, cnt = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i-1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt > 2) {
                while (i < nums.length && nums[i] == nums[i-1]) i++;
                cnt = 1;
            }
            if (i < nums.length) nums[len++] = nums[i++];
        }
        return len;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        //int[] nums = new int[] {1,1,1,1,2,2,2,3};
        int[] nums = new int[] {1,1,1};
        int len = rd.removeDuplicates(nums);
        System.out.println(len);
    }

}
