package tree;

/**
 * no.543: Diameter of Binary Tree
 * Created by flex on 17-4-21.
 * @author flex
 */
public class DiameterofBinaryTree {

    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int diameter = depth(root.left) + depth(root.right);
        int dl = diameterOfBinaryTree(root.left);
        int dr = diameterOfBinaryTree(root.right);
        return Math.max(Math.max(dl, dr), diameter);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    // compute the depth only once
    private static int diameter = 0;
    private static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        depth2(root);
        return diameter;
    }

    private static int depth2(TreeNode root) {
        if (root == null) return 0;
        int dl = depth2(root.left);
        int dr = depth2(root.right);
        if (dl + dr > diameter) diameter = dl + dr;
        return Math.max(dl, dr) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree2(root));
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree2(root));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree2(root));
    }
}
