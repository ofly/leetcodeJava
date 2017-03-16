import java.util.Arrays;

/**
 * Created by flex on 17-3-16.
 * no.31 Next Permutation
 * @author flex
 */

/* Problem: Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples: input → output
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

/* 即将数转换为大一点的数 */
public class NextPermutation {


    private void nextPermutation(int[] nums) {
        int i = nums.length;
        // 从后往前，找到第一个比其前一个数大的数
        while (--i > 0) if (nums[i] > nums[i-1]) break;
        if (i != 0) {
            int j = i + 1;
            while (j<nums.length && nums[j]>nums[i-1]) j++;
            swap(nums, i-1, --j);
        }
        // reverse nums[i:]
        int j = nums.length-1;
        while (i < j) swap(nums, i++, j--);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[] {1, 2, 3, 4};
        System.out.println("0: " + Arrays.toString(nums));
        for (int i=1; i<10; i++) {
            np.nextPermutation(nums);
            System.out.println(i + ": " + Arrays.toString(nums));
        }
    }
}
