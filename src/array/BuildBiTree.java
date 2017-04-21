package array;

/**
 * Created by flex on 17-2-23.
 * @author flex
 * no.105 Construct Binary Tree from Preorder and Inorder Traversal
 * no.106 Construct Binary Tree from Inorder and Postorder Traversal
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

    /*根据先序和中序，构建二叉树*/
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length-1);
    }
    /*添加参数，重载该方法*/
    private TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (inEnd < inStart) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        //if (len == 1) return root;
        int pos;
        for (pos=inStart; pos<=inEnd; pos++) if (inorder[pos] == root.val) break;
        System.out.printf("preStart = %d, inStart = %d, pos = %d, inEnd = %d\n", preStart, inStart, pos, inEnd);
        root.left = buildTree(preorder, preStart+1, inorder, inStart, pos-1);
        root.right = buildTree(preorder, pos+(preStart-inStart)+1, inorder, pos+1, inEnd);
        return root;
    }

    /*根据中序和后序，构建二叉树*/
    private TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTree2(inorder, 0, postorder, 0, inorder.length-1);
    }

    private TreeNode buildTree2(int[] inorder, int inStart, int[] postorder, int postStart, int inEnd) {
        if (inEnd < inStart) return null;
        TreeNode root = new TreeNode(postorder[postStart+inEnd-inStart]);
        //if (len == 1) return root;
        int pos;
        for (pos=inStart; pos<=inEnd; pos++) if (inorder[pos] == root.val) break;
        root.left = buildTree2(inorder, inStart, postorder, postStart, pos-1);
        root.right = buildTree2(inorder, pos+1, postorder, pos+(postStart-inStart), inEnd);
        return root;
    }

    private static void printBiTree(TreeNode root) {
        if (root == null) return;
        System.out.printf("%3d", root.val);
        printBiTree(root.left);
        printBiTree(root.right);
    }

    public static void main(String[] args) {
        //int[] preorder = new int[]{1, 2, 4, 5, 3, 6};
        //int[] inorder = new int[]{4, 2, 5, 1, 6, 3};
        //int[] postorder = new int[]{4, 5, 2, 6, 3, 1};
        int[] inorder = new int[]{1, 2, 3, 4};
        int[] postorder = new int[]{4, 3, 2, 1};
        BuildBiTree bbt = new BuildBiTree();
        //TreeNode root = bbt.buildTree(preorder, inorder);
        TreeNode root2 = bbt.buildTree2(inorder, postorder);
        //printBiTree(root);
        System.out.println("\n------------");
        printBiTree(root2);
    }

}
