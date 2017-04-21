package tree;

/**
 * no.226: Invert Binary Tree
 * Created by flex on 17-4-21.
 * @author flex
 */
public class InvertBinaryTree {

    // or mirror?
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        invertTree(root);
    }
}
