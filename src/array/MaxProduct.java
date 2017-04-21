package array;

/**
 * Created by flex on 17-2-22.
 * 152. Maximum Product Subarray
 * @author flex
 */

public class MaxProduct {

    // max product of contiguous numbers in array.
    // Input: [2, 3, -2, 4]
    // Output: 6
    // 解：DP问题
    // tmin[i] - 包含nums[i]在内的最小连乘积
    // tmax[i] - 包含nums[i]在内的最大连乘积
    // tmin[i] = Math.min(nums[i]*tmin[i-1], nums[i], nums[i]*tmax[i-1])
    // tmax[i] = Math.max(nums[i]*tmin[i-1], nums[i], nums[i]*tmax[i-1])
    public int maxPro(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        int[] tmax = new int[nums.length];
        int[] tmin = new int[nums.length];
        tmax[0] = nums[0];
        tmin[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            int tmpmax = nums[i]*tmin[i-1];
            int tmpmin = nums[i]*tmax[i-1];
            tmin[i] = min(nums[i], tmpmax, tmpmin);
            tmax[i] = max(nums[i], tmpmax, tmpmin);
            if (res < tmax[i]) res = tmax[i];
        }
        //printList(tmax);
        //printList(tmin);
        return res;
    }

    public int min(int a, int b, int c) {
        if (a > b) {
            return (b>c)?c:b;
        } else {
            return (a>c)?c:a;
        }
    }

    public int max(int a, int b, int c) {
        if (a > b) {
            return (a>c)?a:c;
        } else {
            return (b>c)?b:c;
        }
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int tmax = 1, tmin = 1, max = nums[0];
        for (int num: nums) {
            int tmpmin = tmax * num;
            int tmpmax = tmin * num;
            tmin = min(num, tmpmax, tmpmin);
            tmax = max(num, tmpmax, tmpmin);
            if (tmax > max) max = tmax;
        }
        return max;
    }

    public void printList(int[] nums) {
        System.out.print("[");
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(" ," + nums[i]);
            }
        }
        System.out.println("]");
    }

    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        System.out.println(mp.maxProduct(new int[]{-2, 2, 0, -5, -3}));
        //System.out.println();
        System.out.println(mp.maxPro(new int[]{-2, 2, 0, -5, -3}));
        //System.out.println(mp.maxPro(new int[]{-4, -3, -2}));
    }
}
