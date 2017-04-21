package tree;

/**
 * no.Sum: of Left Leaves
 * Created by flex on 17-4-21.
 * @author flex
 */
public class SumLeftLeaves {

    // in order list
    private static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) count = root.left.val;
        return count + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        System.out.println(sumOfLeftLeaves(root));
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
}
