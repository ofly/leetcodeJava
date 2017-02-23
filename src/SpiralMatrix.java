import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-2-23.
 * no.54 Spiral Matrix
 * @author flex
 */

public class SpiralMatrix {

    /*ugly, unreadable*/
    public List<Integer> spiralOrder(int[][] matrix) {
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
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0) return results;
        int m = matrix.length, n = matrix[0].length;
        // u - upper line, d - down line, l - left column, r - right column
        int u = 0, d = m - 1, l = 0, r = n - 1, k = 0;
        while (true) {
            // up line
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
    }
}
