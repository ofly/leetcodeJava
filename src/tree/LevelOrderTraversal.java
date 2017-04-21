package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by flex on 17-4-21.
 * no.107: Binary Tree Level Order Traversal II
 * @author flex
 */
public class LevelOrderTraversal {

    // 使用队列存续遍历二叉树，并用idx表示每次遍历的节点的序号
    // 设置一个标记：当前层是否所有节点都没有孩子节点
    private static List<List<Integer>> levelOrderBottomII(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        List<TreeNode> queue = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        results.add(res);
        boolean hasChild = false;
        int idx = 0, layer = 1;
        queue.add(root);
        while (idx < queue.size()) {
            TreeNode node = queue.get(idx);
            if (node != null) {
                res.add(node.val);
                if (node.left != null || node.right != null) hasChild = true;
                queue.add(node.left);
                queue.add(node.right);
            } else {
                queue.add(null);
                queue.add(null);
            }
            if (idx+2 == (int)Math.pow(2, layer)) {
                if (! hasChild) break;
                results.add(0, new ArrayList<>());
                res = results.get(0);
                layer++;
                hasChild = false;
            }
            idx++;
        }
        return results;
    } // Time Limit Exceeded

    // 根本不需要idx，只需在遍历时把每一层的val添加到列表中即可
    // 其实是一个BFS的过程，核心思想是：在遍历某一层时，把下一层所有non-null节点加入队列
    private static List<List<Integer>> levelOrderBottomII2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int layerCount = queue.size();
            List<Integer> res = new ArrayList<>(layerCount);
            for (int i=0; i<layerCount; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(0, res);
        }
        return result;
    }

    // DFS
    private static List<List<Integer>> levelOrderBottomII3(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    private static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new ArrayList<>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = null;
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = null;
        // System.out.println(levelOrderBottomII(root));
        System.out.println(levelOrderBottomII2(root));
    }
}
