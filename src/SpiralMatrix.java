import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-2-23.
 * no.54 Spiral Matrix
 * no.59 Spiral Matrix II
 * @author flex
 */

/* Problem 54: Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * Problem 59: Given an integer n, generate a square matrix filled
 * with elements from 1 to n^2 in spiral order.
 */
public class SpiralMatrix {

    /*ugly, unreadable*/
    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int xlen = matrix.length;
        if (xlen == 0) return results;
        int ylen = matrix[0].length;
        for (int i=0, j=0; i<(xlen+1)/2 && j<(ylen+1)/2; i++, j++) {
            int x = i, y = i;
            while (y < ylen-j) {
                results.add(matrix[x][y++]);
            }
            x++; y--;
            if (x >= xlen-i) break;
            while (x < xlen-i) {
                results.add(matrix[x++][y]);
            }
            if (y == j) break;
            x--;
            while (y > j) {
                results.add(matrix[x][--y]);
            }
            x--;
            while (x > i) {
                results.add(matrix[x--][y]);
            }
        }
        return results;
    }

    /* easy understand */
    private List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0) return results;
        int m = matrix.length, n = matrix[0].length;
        // u - upper line, d - down line, l - left column, r - right column
        int u = 0, d = m - 1, l = 0, r = n - 1, k = 0;
        while (true) {
            // upper line
            for (int col = l; col <= r; col++) results.add(matrix[u][col]);
            if (++u > d) break;
            // right column
            for (int row = u; row <= d; row++) results.add(matrix[row][r]);
            if (--r < l) break;
            // down line
            for (int col = r; col >= l; col--) results.add(matrix[d][col]);
            if (--d < u) break;
            // left column
            for (int row = d; row >= u; row--) results.add(matrix[row][l]);
            if (++l > r) break;
        }
        return results;
    }

    /* gen spiral square matrix */
    private int[][] generateMatrix(int n) {
        int l = 0, r = n-1, u = 0, d = n-1;
        int matrix[][] = new int[n][n];
        int num = 1, max = n*n;
        while (num <= max) {
            // upper line
            for (int i=l; i<=r; i++) matrix[u][i] = num++;
            u++;
            // right column
            for (int i=u; i<=d; i++) matrix[i][r] = num++;
            r--;
            // down column
            for (int i=r; i>=l; i--) matrix[d][i] = num++;
            d--;
            // left line
            for (int i=d; i>=u; i--) matrix[i][l] = num++;
            l++;
        }
        return matrix;
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
        int[][]matrix = new int[4][1];
        int num = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = num++;
            }
        }
        SpiralMatrix sm = new SpiralMatrix();
        //List<Integer> results = sm.spiralOrder(matrix);
        List<Integer> results = sm.spiralOrder2(matrix);
        for (int i=0; i<results.size(); i++) {
            System.out.printf("%-3d", results.get(i));
        }
        System.out.println();

        System.out.println("-------------------");
        int[][] m = sm.generateMatrix(3);
        printMatrix("generateMatrix(3):", m);
    }
}
