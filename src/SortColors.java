import java.util.Arrays;

/**
 * Created by flex on 17-3-16.
 * no.75 Sort Colors
 * @author flex
 */

public class SortColors {

    // two-pass, O(2*n)
    private void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num: nums) count[num]++;
        int start = 0;
        for (int i=0; i<3; i++) {
            for (int j=start; j<start+count[i]; j++) nums[j] = i;
            start += count[i];
        }
    }

    // one-pass, but O(3*n)
    private void sortColors2(int[] nums) {
        int n0 = 0, n1 = 0, n2 = 0;
        for (int i=0; i<nums.length; i++) {
            switch (nums[i]) {
                case 2: nums[n2++] = 2; break;
                case 1: nums[n2++] = 2; nums[n1++] = 1; break;
                case 0: nums[n2++] = 2; nums[n1++] = 1; nums[n0++] = 0; break;
            }
        }
    }

    // one-pass
    private void sortColors3(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            while (l < r && nums[l] == 0) l++;
            while (l < r && nums[r] == 2) r--;
            if (l < r) {
                if (nums[l] == 2) swap(nums, l, r--);
                if (nums[r] == 0) swap(nums, l++, r);
                if (nums[l] == 1 && nums[r] == 1) {
                    int m = l + 1;
                    while (m < r && nums[m] == 1) m++;
                    if (m >= r) break;
                    if (nums[m] == 0) swap(nums, l++, m);
                    if (nums[m] == 2) swap(nums, m, r--);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        // int[] nums = new int[] {1, 2, 0, 0, 2, 1, 1, 2};
        int[] nums = new int[] {2,2};
        // int[] nums = new int[] {0,0};
        System.out.println(Arrays.toString(nums));
        // sc.sortColors(nums);
        // System.out.println(Arrays.toString(nums));
        //sc.sortColors2(nums);
        // System.out.println(Arrays.toString(nums));
        sc.sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
