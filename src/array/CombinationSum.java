package array;

import java.util.*;

/**
 * Created by flex on 17-2-22.
 * no.39 Combination Sum
 * no.40 Combination Sum II
 * no.216 Combination Sum III
 * @author flex
 */

/* Problem 39: Given a set of candidate numbers (C) (without duplicates) and a target
 * number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Note: The same repeated number may be chosen from C unlimited number of times.
 *
 * Problem 40: C may has duplicates numbers, and each number in C may only be used once
 * in the combination.
 *
 * Problem 216: Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 */

public class CombinationSum {

    // DP: Suppose op[i] is the collection of combination that sum equal to i
    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> op = new HashMap<>();
        Arrays.sort(candidates);
        // run through all targets from candidates[0] to target
        for (int num=candidates[0]; num<=target; num++) {
            List<List<Integer>> list = new ArrayList<>();
            // run through all candidates <= num
            for (int candi: candidates) {
                if (candi > num) break;
                if (candi == num) {
                    list.add(Collections.singletonList(candi));
                } else if (op.containsKey(num-candi)) {
                    for (List<Integer> l: op.get(num-candi)) {
                        if (candi <= l.get(0)) {    // 避免重复
                            List<Integer> cl = new ArrayList<>();
                            cl.add(candi);
                            cl.addAll(l);
                            list.add(cl);
                        }
                    }
                }
            }
            op.put(num, list);
        }
        return op.containsKey(target)?op.get(target):new ArrayList<>();
    }

    // backtracing: recursion
    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> list, int[] candidates, int start, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            helper(results, list, candidates, i, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }

    // DP:
    private List<List<Integer>> combinationSumII(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> op = new HashMap<>();
        Arrays.sort(candidates);
        for (int num=candidates[0]; num<=target; num++) {
            op.put(num, new ArrayList<>());
        }
        for (int num=candidates[0]; num<=target; num++) {
            List<List<Integer>> list = new ArrayList<>();
            int idx = 0;
            while (idx < candidates.length) {
                if (candidates[idx] >= num && !op.containsKey(num)) {
                    list.add(Collections.singletonList(candidates[idx]));
                } else if (op.containsKey(num-candidates[idx])) {
                    for (List<Integer> l: op.get(num-candidates[idx])) {
                        int i = 0, k = 0;
                        while (idx < l.size()) if (candidates[k++] == l.get(idx)) idx++;
                        if (i >= k) {
                            List<Integer> cl = new ArrayList<>();
                            cl.addAll(l);
                            cl.add(candidates[i]);
                            list.add(cl);
                        }
                    }
                }
                idx++;
                while (idx < candidates.length && candidates[idx] == candidates[idx-1]) idx++;
            }
            op.put(num, list);
        }
        return op.containsKey(target)?op.get(target):new ArrayList<>();
    }

    // backtracing recursion
    private List<List<Integer>> combinationSumII2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        helperII(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    private void helperII(List<List<Integer>> results, List<Integer> list, int[] candidates, int start, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<candidates.length && candidates[start] <= target; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            helperII(results, list, candidates, i+1, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }

    // DP:

    // backtracing recursion
    private List<List<Integer>> combinationSumIII2(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        helperIII(results, new ArrayList<>(), k, n);
        return results;
    }

    private void helperIII(List<List<Integer>> results, List<Integer> list, int k, int n) {
        if (k == 0 && n == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        int start = (list.size()>0)?list.get(list.size()-1)+1:1;
        for (int num=start; num<10; num++) {
            if (n < num) break;
            list.add(num);
            helperIII(results, list, k-1, n-num);
            list.remove(list.size()-1);
        }
    }

    public static void printList(List<List<Integer>> numsList) {
        System.out.print("[");
        for (List<Integer> list : numsList) {
            System.out.print("[");
            for (int i=0; i<list.size(); i++) {
                if (i == 0) {
                    System.out.print(list.get(i).toString());
                } else {
                    System.out.print(" ," + list.get(i).toString());
                }
            }
            System.out.print("], ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        printList(cs.combinationSum2(new int[]{6, 2, 3, 7}, 7));
        System.out.println("===========");
        printList(cs.combinationSumII2(new int[]{2, 2, 2}, 4));
        System.out.println("===========");
        printList(cs.combinationSumIII2(3, 9));
    }
}
