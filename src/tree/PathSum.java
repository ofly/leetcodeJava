package tree;

/**
 * no.437: Path Sum III
 * no.112: Path Sum
 * Created by flex on 17-4-21.
 * @author flex
 */
public class PathSum {

    private static boolean hasPathSum(TreeNode root, int sum) {
        return root != null
                && ((root.left == null && root.right == null && root.val == sum)
                    || hasPathSum(root.left, sum-root.val)
                    || hasPathSum(root.right, sum-root.val)
                );
    }

    // pre-order list
    private static int pathSumIII(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = 0;
        count += sumCount(root, sum);
        count += pathSumIII(root.left, sum);
        count += pathSumIII(root.right, sum);
        return count;
    }

    // DP: the result is the count of pathsum = sum, and the path start with root
    private static int sumCount(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = 0;
        count += (root.val == sum)?1:0;
        count += sumCount(root.left, sum-root.val);
        count += sumCount(root.right, sum-root.val);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(pathSumIII(root, 8));
        System.out.println(pathSumIII(root, 7));
        System.out.println(hasPathSum(root, 16));
    }
}
