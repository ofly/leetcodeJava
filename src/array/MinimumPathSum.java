package array;

/**
 * Created by flex on 17-3-13.
 * no.64 Minimum Path Sum
 * @author flex
 */

/* Problem: Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
*/
public class MinimumPathSum {

    // DP: Suppose pro[i][j] is the min sum from grid[0][0] to grid[i][j]
    private int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] pro = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        pro[i][j] = grid[i][j];
                        continue;
                    }
                    if (i == 0) pro[i][j] = pro[i][j-1] + grid[i][j];
                    if (j == 0) pro[i][j] = pro[i-1][j] + grid[i][j];
                } else {
                    pro[i][j] = Math.min(pro[i-1][j], pro[i][j-1]) + grid[i][j];
                }
            }
        }
        return pro[m-1][n-1];
    }

    // don't need pro, modify grid at local space.
    private int minPathSum2(int[][] grid) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                if (i != 0 && j == 0) grid[i][j] += grid[i-1][j];
                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return (grid.length == 0)?0:grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = new int[][] {
                {1, 1, 2, 4},
                {4, 3, 3, 1},
                {1, 1, 2, 2},
                {5, 2, 1, 2}
        };
        System.out.println(mps.minPathSum(grid));
        System.out.println(mps.minPathSum2(grid));
    }

}
