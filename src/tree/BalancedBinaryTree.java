package tree;

/**
 * no.110: Balanced Binary Tree
 * Created by flex on 17-4-21.
 * @author flex
 */
public class BalancedBinaryTree {

    static boolean isBalanced(TreeNode root) {
        return root == null || helper(root) != -1;
    }

    // if return -1, is not balance
    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int lh = helper(root.left);
        if (lh == -1) return -1;
        int rh = helper(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        System.out.println(isBalanced(root));
        root.left = new TreeNode(5);
        System.out.println(isBalanced(root));
        root.left.left = new TreeNode(6);
        System.out.println(isBalanced(root));
    }
}
