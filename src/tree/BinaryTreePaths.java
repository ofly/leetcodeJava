package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * no.257: Binary Tree Paths
 * Created by flex on 17-4-21
 * @author flex
 */
public class BinaryTreePaths {

    // DFS
    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) helper(root, result, Integer.toString(root.val));
        return result;
    }

    private static void helper(TreeNode root, List<String> result, String str) {
        if (root.left == null && root.right == null) result.add(str);
        if (root.left != null) helper(root.left, result, str + "->" + Integer.toString(root.left.val));
        if (root.right != null) helper(root.right, result, str + "->" + Integer.toString(root.right.val));
    }

    // DFS without heler function
    private static List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if (root == null) return paths;
        if (root.left == null && root.right == null){
            paths.add(root.val + "");
            return paths;
        }
        for (String path: binaryTreePaths2(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path: binaryTreePaths2(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = null;
        // System.out.println(levelOrderBottomII(root));
        System.out.println(binaryTreePaths(root));
        System.out.println(binaryTreePaths2(root));
    }
}
