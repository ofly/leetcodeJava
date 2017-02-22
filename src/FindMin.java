/**
 * Created by flex on 17-2-22.
 * @author flex
 * number: 153
 */
public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length < 0) return -1;
        if (nums[0] <= nums[nums.length-1]) {
            return nums[0];
        } else {
            int i;
            for (i=1; i<nums.length; i++) {
                if (nums[i] < nums[i-1]) {
                    break;
                }
            }
            return nums[i];
        }
    }

    public static void main(String[] args) {
        FindMin fm = new FindMin();
        System.out.println(fm.findMin(new int[]{0}));
        System.out.println(fm.findMin(new int[]{0,1,2,4,5,6,7}));
        System.out.println(fm.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
