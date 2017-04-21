package array;

/**
 * Created by flex on 17-2-23.
 * no.48 Rotate Image
 * @author flex
 */

public class RotateImage {
    /* rotate matrix 90 degrees by clockwise in space. */
    public void rotate(int[][] matrix) {
        int x = 0, y = 0;
        while (x + y <= matrix.length) {
            int dx = x, dy = y;
            int num = matrix.length - x - y;
            for (int i=1; i<num; i++) {
                int tmp = matrix[dx][dy];
                for (int j=0; j<3; j++) {
                    int ny = dx, nx = matrix.length - dy - 1; // 顺时针90度
                    matrix[dx][dy] = matrix[nx][ny];
                    dx = nx; dy = ny;
                }
                matrix[dx][dy] = tmp;
                dx = x; dy = dx + i;
            }
            x++; y++;
        }
    }

    /* 按/对角线翻转，再安装横轴翻转*/
    public void rotate2(int[][] matrix) {
        int len = matrix.length - 1;
        for (int i=0; i<len; i++) {
            for (int j=0; j<len-i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-j][len-i];
                matrix[len-j][len-i] = tmp;
            }
        }
        for (int i=0; i<matrix.length/2; i++) {
            for (int j=0; j<matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-i][j];
                matrix[len-i][j] = tmp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            System.out.print("[");
            for (int j=0; j<matrix.length; j++) {
                System.out.printf("%-3d", matrix[i][j]);
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[][]matrix = new int[6][6];
        int num = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                matrix[i][j] = num++;
            }
        }
        RotateImage rt = new RotateImage();
        printMatrix(matrix);
        rt.rotate(matrix);
        System.out.println("after rotation:");
        printMatrix(matrix);
        rt.rotate2(matrix);
        System.out.println("after rotation2:");
        printMatrix(matrix);
    }
}
