import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-2-22.
 * number: 442
 * @author flex
 */

public class FindDuplicates {
    // 1 ≤ a[i] ≤ n
    // Input: [4,3,2,7,8,2,3,1]
    // Output: [2, 3]
    // requre: O(n) runtime
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) {
                results.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return results;
    }

    public void printList(List<Integer> list) {
        System.out.print("[");
        for (int i=0; i<list.size(); i++) {
            if (i == 0) {
                System.out.print(list.get(i).toString());
            } else {
                System.out.print(" ," + list.get(i).toString());
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        FindDuplicates fd = new FindDuplicates();
        fd.printList(fd.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

}
