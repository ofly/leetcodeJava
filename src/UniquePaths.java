/**
 * Created by flex on 17-3-13.
 * no.62 Unique Paths
 * no.63 Unique Paths II
 * @author flex
 */

/* Problem: A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * -------- one step per time? --------
 *
 * Problem: Now consider if some obstacles are added to the grids.
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * How many unique paths would there be?
 */
public class UniquePaths {

    // DP: Suppose pro[i][j] is the number of unique paths from [0][0] to [i][j]
    private int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] grid = new int[m][n];
        for (int i=0; i<m; i++) grid[i][0] = 1;
        for (int j=1; j<n; j++) grid[0][j] = 1;
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

    private int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[] pro = new int[n];
        pro[0] = 1;
        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                pro[j] += pro[j-1];
            }
        }
        return pro[n-1];
    }

    // use formula:C(m+n-2,m-1)
    private int uniquePaths3(int m, int n) {
        int cnt = Math.min(m-1, n-1);
        int stp = m + n - 2;
        int sm = 1, sn = 1;
        while (cnt > 0) {
            sm *= stp--;
            sn *= cnt--;
        }
        return sm/sn;
    }

    // DP: Suppose pro[i][j] is the number of unique paths from [0][0] to [i][j]
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m <= 0) return 0;
        int n = obstacleGrid[0].length;
        if (n <= 0) return 0;
        int[][] pro = new int[m][n];
        for (int i=0; i<m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            pro[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            pro[0][j] = 1;
        }
        if (pro[0][0] == 0) return 0;
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] == 1) pro[i][j] = 0;
                else pro[i][j] = pro[i-1][j] + pro[i][j-1];
            }
        }
        return pro[m-1][n-1];
    }

    // DP: O(n) space
    // Suppose pro[i] is the number of unique paths from [0][0] to [i][j]
    private int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid.length <= 0) return 0;
        int[] pro = new int[obstacleGrid[0].length];
        pro[0] = 1;
        for (int[] array: obstacleGrid) {
            for (int j=1; j<obstacleGrid[0].length; j++) {
                // pro[j-1] is the left, and pro[j] is the upper
                if (array[j] == 1) pro[j] = 0;
                else pro[j] += pro[j-1];
            }
        }
        return pro[obstacleGrid[0].length - 1];
    }

    private static void printMatrix(String msg, int[][] matrix) {
        System.out.printf("%s:\n", msg);
        for (int[] array: matrix) {
            for (int num: array) {
                System.out.printf("%-3d ", num);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.printf("%d, %d\n", up.uniquePaths(1,1), up.uniquePaths2(1, 1));
        System.out.printf("%d, %d\n", up.uniquePaths(2,3), up.uniquePaths2(2, 3));
        System.out.printf("%d, %d\n", up.uniquePaths(3,7), up.uniquePaths2(3, 7));
        int[][] obstacleGrid = new int[][] {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0}
        };
        // printMatrix("obstacle grid", obstacleGrid);
        System.out.printf("%d\n", up.uniquePathsWithObstacles(obstacleGrid));
        System.out.printf("%d\n", up.uniquePathsWithObstacles2(obstacleGrid));
    }
}
