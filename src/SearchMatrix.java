/**
 * Created by flex on 17-3-9.
 * no.74 Search a 2D Matrix
 * @author flex
 */

public class SearchMatrix {

    // 二分查找：O(log(m*n))
    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int len = matrix[0].length;
        int l = 0, r = matrix.length*len - 1;
        boolean res = false;
        while (l<=r) {
            int m = (l+r)/2;
            int num = matrix[m/len][m%len];
            if (num == target) {
                res = true;
                break;
            }
            if (num > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    // 十字逼近：最坏O(m+n)
    private boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    // 二分查找 + 十字逼近：O(log(m) + log(n))
    private boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int l = 0, r = matrix[0].length - 1;
        if (matrix[l][r] == target) return true;
        int i = matrix.length-1;
        // 二分法：找到target可能在的行
        while (matrix[l][r] < target && l < i) {
            int m = (l+i)/2;
            if (matrix[m][r] == target) return true;
            if (matrix[m][r] > target) {
                i = m - 1;
            } else {
                l = m + 1;
            }
        }
        // 二分法：找到target可能的具体位置
        int j = 0;
        while (j <= r) {
            int m = (j+r)/2;
            if (matrix[l][m] == target) return true;
            if (matrix[l][m] > target) {
                r = m - 1;
            } else {
                j = m + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        int[][] matirx = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                //{23, 30, 34, 50}
        };
        System.out.println(sm.searchMatrix(matirx, 5));
        System.out.println(sm.searchMatrix2(matirx, 16));
        System.out.println(sm.searchMatrix3(matirx, 5));
    }
}
