/**
 * Created by flex on 17-2-22.
 * @author flex
 * no.11 - Container With Most Water
 */

public class MaxArea {
    // Input: [4, 3, 2, 3, 2]
    // Output: 9
    // 解：两条垂直于X轴的直线围成的最大面积（高度以短的那根为准，长度为X坐标差值）
    // O(n^2)
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                int area = (j-i)*Math.min(height[j], height[i]);
                if (area > maxarea) maxarea = area;
            }
        }
        return maxarea;
    }
    // 1)
    // suppose maxarea is [ai, aj], where 0 <= i < j < n
    //     maxares = min(ai, aj) * (j - i)
    // when j < l < n:
    //     min(ai, al) * (l - i) < min(ai, aj) * (j - i)
    // because l > j, so (l-i) > (j-i), so
    //     min(ai, al) < min(ai, aj)
    // so
    //     aj > al, (j < l < n)
    // similarity:
    //     ai > am, (0 < m < i)

    // 2)
    // if ai < aj, so
    //     area(ai, aj) > area(ai, ak), where i < k < j
    // so i++
    // similarity:
    // if ai < aj, j--

    // 1) and 2) maxarea can be reached.
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, (r-l)*Math.min(height[r], height[l]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] height = new int[15000];
        for (int i=0; i<15000; i++) {
            height[i] = 15000-i;
        }
        System.out.println(ma.maxArea(height));
        System.out.println(ma.maxArea2(height));
        //System.out.println(ma.maxArea(new int[]{4, 3, 2, 3, 2}));
    }

}
