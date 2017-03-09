/**
 * Created by flex on 17-3-9.
 * no.238 Product of Array Except Self
 * @author flex
 */

public class ProductExceptSelf {

    // 使用了除法
    private int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int product = 1, index = -1;
        int zeros = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                index = i;
            } else {
                product *= nums[i];
            }
            products[i] = 0;
        }
        if (zeros > 1) return products;
        if (zeros == 1) {
            products[index] = product;
        } else {
            for (int i=0; i<products.length; i++) {
                products[i] = product / nums[i];
            }
        }
        return products;
    }

    // 只用乘法
    private int[] productExceptSelf2(int[] nums) {
        int[] pro = new int[nums.length];
        pro[0] = 1;
        // pro[i] is the product of {nums[j] where j < i}
        for (int i=1; i<nums.length; i++) {
            pro[i] = pro[i-1] * nums[i-1];
        }
        int right = 1;  // product of {nums[j] where j > i}
        for (int i=nums.length-1; i>=0; i--) {
            pro[i] *= right;
            right *= nums[i];
        }
        return pro;
    }

    public static void printArray(int[] arr) {
        for (int num: arr) {
            System.out.printf("%-3d", num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] results = pes.productExceptSelf(new int[] {1, 2, 3, 4});
        printArray(results);
    }
}
