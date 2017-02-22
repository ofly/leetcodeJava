import java.util.*;

/**
 * Created by flex on 17-2-22.
 * number: 39, 40
 * @author flex
 */

public class CombinationSum {

    // DP
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> op = new HashMap<>();
        Arrays.sort(candidates);
        // run through all targets from candidates[0] to target
        for (int num=candidates[0]; num<=target; num++) {
            List<List<Integer>> list = new ArrayList<>();
            // run through all candidates <= num
            for (int candi: candidates) {
                if (candi > num) {
                    break;
                } else if (candi == num) {
                    list.add(Collections.singletonList(candi));
                } else if (op.containsKey(num-candi)) {
                    for (List<Integer> l: op.get(num-candi)) {
                        if (candi <= l.get(0)) {
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
        if (op.containsKey(target)) {
            return op.get(target);
        } else {
            return new ArrayList<>();
        }
    }

    // DP
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> op = new HashMap<>();
        Arrays.sort(candidates);
        Collections.reverse(Arrays.asList(candidates));    // 1, 1, 2, 5, 6, 7, 10
        for (int num=candidates[0]; num<=target; num++) {
            List<List<Integer>> list = new ArrayList<>();
            for (int candi: candidates) {
                if (candi > num) {
                    break;
                } else if (candi == num && (!op.containsKey(candi))) {
                    list.add(Collections.singletonList(num));
                } else if (num-candi <= candi && op.containsKey(candi)) {
                    for (List<Integer> l: op.get(candi)) {

                    }
                }
            }
            op.put(num, list);
        }

        if (op.containsKey(target)) {
            return op.get(target);
        } else {
            return new ArrayList<>();
        }
    }

    public void printList(List<List<Integer>> numsList) {
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
        cs.printList(cs.combinationSum(new int[]{6, 2, 3, 7}, 7));
        cs.printList(cs.combinationSumII(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
