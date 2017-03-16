import java.util.Arrays;

/**
 * Created by flex on 17-3-16.
 * no.75 Sort Colors
 * @author flex
 */

public class SortColors {
    private void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num: nums) count[num]++;
        int start = 0;
        for (int i=0; i<3; i++) {
            for (int j=start; j<start+count[i]; j++) nums[j] = i;
            start += count[i];
        }
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = new int[] {1, 2, 0, 0, 2, 1, 1, 2};
        System.out.println(Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
