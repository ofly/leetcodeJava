/**
 * Created by flex on 17-2-23.
 * @author flex
 * no.105 Construct Binary Tree from Preorder and Inorder Traversal
 */

public class BuildBiTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*根据先序和中序，构建二叉树，做了数组的拷贝，效率不高*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, preorder.length);
        /*
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int pos = 0;
        while (inorder[pos] != preorder[0]) pos++;
        int[] lpreorder = new int[pos];
        int[] rpreorder = new int[preorder.length-pos-1];
        int[] linorder = new int[pos];
        int[] rinorder = new int[preorder.length-pos-1];
        System.arraycopy(preorder, 1, lpreorder, 0, pos);
        System.arraycopy(preorder, pos+1, rpreorder, 0, preorder.length-pos-1);
        System.arraycopy(inorder, 0, linorder, 0, pos);
        System.arraycopy(inorder, pos+1, rinorder, 0, inorder.length-pos-1);
        root.left = buildTree(lpreorder, linorder);
        root.right = buildTree(rpreorder, rinorder);
        return root;
        */
    }
    /*添加参数，重载该方法*/
    public TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int len) {
        if (len <= 0) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = inStart;
        while (pos < inorder.length && (inorder[pos] != preorder[preStart])) pos++;
        root.left = buildTree(preorder, preStart+1, inorder, inStart, pos-inStart);
        root.right = buildTree(preorder, preStart+pos+1, inorder, pos+1, len-(pos-inStart)-1);
        return root;
    }

    public static void printBiTree(TreeNode root) {
        if (root != null) System.out.printf("%3d", root.val);
        if (root.left != null) printBiTree(root.left);
        if (root.right != null) printBiTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3};
        BuildBiTree bbt = new BuildBiTree();
        TreeNode root = bbt.buildTree(preorder, inorder);
        printBiTree(root);
    }

}
