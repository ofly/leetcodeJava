package tree;

/**
 * no.108: Convert Sorted Array to Binary Search Tree
 * Created by flex on 17-4-21.
 * @author flex
 */
public class SortedArrayToBST {

    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private static TreeNode helper(int[] nums, int s, int e) {
        if (s > e) return null;
        int m = (s+e)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, s, m-1);
        root.right = helper(nums, m+1, e);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(BalancedBinaryTree.isBalanced(sortedArrayToBST(new int[]{0, 1})));
        System.out.println(BalancedBinaryTree.isBalanced(sortedArrayToBST(new int[]{0, 1, 2})));
        System.out.println(BalancedBinaryTree.isBalanced(sortedArrayToBST(new int[]{0, 1, 2, 3})));
    }
}
