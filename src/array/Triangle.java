package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-2-23.
 * no.120 array.Triangle
 * @author flex
 */

/* Given a triangle, find the minimum path sum from top to bottom. */
public class Triangle {

    /* Each step you may move to adjacent numbers on the row below.
    * DP: op[i][j] is min sum which contains triangle[i][j], 0 <= j <= i
    * op[i][j] = min(op[i-1][j-1], op[i-1][j]) + nums[i][j], 1 <= j <= i-1
    * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int layer = triangle.size();
        List<Integer> op = new ArrayList<>(layer);
        List<Integer> tmp = new ArrayList<>(layer);
        op.add(triangle.get(0).get(0));
        for (int i=1; i<layer; i++) {
            for (int j=0; j<=i; j++) {
                int minnum;
                if (j == 0) {
                    minnum = op.get(j) + triangle.get(i).get(j);
                } else if (j == i) {
                    minnum = op.get(j-1) + triangle.get(i).get(j);
                } else {
                    minnum = triangle.get(i).get(j) + Math.min(op.get(j-1), op.get(j));
                }
                tmp.add(minnum);
            }
            op.clear();
            for (int num: tmp) {
                op.add(num);
            }
            tmp.clear();
        }
        int minsum = Integer.MAX_VALUE;
        for (int num: op) {
            if (num < minsum) minsum = num;
        }
        return minsum;
    }

    /* from bottom to top make solutions better! */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int layer = triangle.size();
        int[] minmum = new int[layer+1];
        while (layer-- > 0) {
            for (int i=0; i<=layer; i++) {
                minmum[i] = Math.min(minmum[i], minmum[i+1]) + triangle.get(layer).get(i);
            }
        }
        return minmum[0];
    }

    public static List<List<Integer>> makeTriangle(int[] nums, int layer) {
        List<List<Integer>> triangle = new ArrayList<>();
        int k = 0;
        for (int i=1; i<=layer; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<i && k < nums.length; j++) {
                row.add(nums[k++]);
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int layer = 4;
        int[] nums = new int[]{2, 3, 4, 6, 5, 7, 4, 1, 8, 3};
        List<List<Integer>> triangle = makeTriangle(nums, layer);
        Triangle tri = new Triangle();
        System.out.println(tri.minimumTotal(triangle));
        System.out.println(tri.minimumTotal2(triangle));
    }
}
