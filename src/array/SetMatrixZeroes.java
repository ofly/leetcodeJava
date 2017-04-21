package array;

/**
 * Created by flex on 17-3-9.
 * @author flex
 */

/* Problem: no.73 Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {

    // 直觉的解法不仅复杂度很高，而且是错误的！
    // 时间复杂度O(m*n)，空间复杂度O(n)
    private void setMatrixZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        boolean[] zeroColumn = new boolean[matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            boolean hasZero = false;
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] != 0) continue;
                zeroColumn[j] = true;   // 标记第j列
                if (hasZero) continue;
                hasZero = true;
            }
            if (hasZero) {              // 第i行置零
                for (int k=0; k<matrix[0].length; k++) {
                    matrix[i][k] = 0;
                }
            }
        }
        for (int j=0; j<zeroColumn.length; j++) {
            if (!zeroColumn[j]) continue;
            for (int i=0; i<matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    // use matrix[*][0] as extra space
    // 时间复杂度：O(m*n)，空间复杂度：O(1)
    private void setMatrixZeroes2(int[][] matrix) {
        if (matrix.length == 0) return;
        int rows = matrix.length, cols = matrix[0].length;
        boolean col0 = false;   // 第0列是否有元素为0
        for (int i=0; i<rows; i++) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j=0; j<cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;   // 标记第i行
                    matrix[0][j] = 0;   // 标记第j列
                }
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (col0) matrix[i][0] = 0;
        }
    }

    public static void printArray(boolean[] arr) {
        for (boolean num: arr) {
            System.out.printf("%s ", num);
        }
        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] nums: matrix) {
            for (int num: nums) {
                System.out.printf("%-3d", num);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 0, 20},
                //{23, 30, 34, 50}
        };
        printMatrix(matrix);
        smz.setMatrixZeroes2(matrix);
        printMatrix(matrix);
    }

}
