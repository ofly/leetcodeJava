package tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * no.501: Find Mode in Binary Search Tree
 * Created by flex on 17-4-21.
 * @author flex
 */
public class BinarySearchTree {

    // 使用map，遍历二叉搜索树一次即可，not O(1) space
    private static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        helper(root, count);
        int max = 0;
        for (int key: count.keySet()) {
            if (count.get(key) > max) max = count.get(key);
        }
        for (int key: count.keySet()) {
            if (count.get(key) == max) result.add(key);
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private static void helper(TreeNode root, Map<Integer, Integer> count) {
        if (root == null) return;
        if (count.containsKey(root.val)) {
            count.put(root.val, count.get(root.val) + 1);
        } else {
            count.put(root.val, 1);
        }
        helper(root.left, count);
        helper(root.right, count);
    }

    // O(1) Space
    // Runtime Error Message: Line 48: java.lang.ArrayIndexOutOfBoundsException: 5
    // I don't know why?
    private static int count = 0;
    private static int maxCount = 0;
    private static int modeCount = 0; // 众数的个数
    private static int modes[];
    private static Integer val = null;
    private static int idx = 0;
    private static int[] findModes(TreeNode root) {
        inorderCount(root); // get modeCount
        modes = new int[modeCount];
        val = null;
        count = 0;
        inorderModes(root);
        return modes;
    }

    // 中序遍历二叉排序树（可以得到一个有序的列表），获得maxCount
    private static void inorderCount(TreeNode root) {
        if (root == null) return;
        inorderCount(root.left);
        count = (val != null && root.val == val)?count+1:1;
        if (count > maxCount) {
            modeCount = 1;
            maxCount = count;
        } else if (count == maxCount) {
            modeCount++;
        }
        val = root.val;
        inorderCount(root.right);
    }

    // 再次中序遍历二叉排序树（可以得到一个有序的列表），计算modes
    private static void inorderModes(TreeNode root) {
        if (root == null) return;
        inorderModes(root.left);
        count = (val != null && root.val == val)?count+1:1;
        val = root.val;
        if (count == maxCount) modes[idx++] = root.val;
        inorderModes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-2);
        root.right.left = new TreeNode(-2);
        //root.right.left = new TreeNode(2);
        //root.right.right = null;
        //root.right.left = new TreeNode(5);
        //root.right.right = new TreeNode(6);
        // System.out.println(levelOrderBottomII(root));
        // System.out.println(IntStream.of(findMode(root)).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.of(findModes(root)).boxed().collect(Collectors.toList()));
    }
}
