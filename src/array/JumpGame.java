package array;

import java.util.Arrays;

/**
 * Created by flex on 17-2-27.
 * no.55 Jump Game
 * @author flex
 */

public class JumpGame {
    // A = [2,3,1,1,4], return true.
    // A = [3,2,1,0,4], return false.
    // 广度优先 timeout
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        // op[i] 为从初始位置跳到第i个元素的最少跳数
        int[] op = new int[nums.length];
        op[0] = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (op[i] == 0) continue;
            for (int j=i+1; j<=i+nums[i]; j++) {
                if (op[j] == 0) {
                    op[j]++;
                }
                if (j == nums.length-1) return true;
            }
        }
        return false;
    }

    // 深度优先 - java.lang.StackOverflowError
    public boolean canJump2(int[] nums, int pos) {
        if (pos == nums.length-1) {
            return true;
        }
        boolean result = false;
        int step = nums[pos];
        while (step > 0) {
            if (step + pos >= nums.length-1) return true;
            if (nums[pos+step] != 0) return canJump2(nums, pos+step);
            step--;
        }
        return false;
    }

    // 深度优先 - 非递归形式 -  Time Limit Exceeded
    public boolean canJump3(int[] nums) {
        int[] step = Arrays.copyOf(nums, nums.length);
        int pos = 0;
        while (pos < step.length-1) {
            if (pos < 0) break;
            if (step[pos] == 0) {
                pos--;
                continue;
            }
            if (pos+step[pos] >= step.length-1) return true;
            if (step[pos+step[pos]] == 0) {
                step[pos]--;
            } else {
                pos += step[pos]--;
            }
        }
        return (pos >= step.length-1);
    }

    // 深度优先 - 从后往前，检查前置节点有无可能达到末位节点
    public boolean canJump4(int[] nums) {
        if (nums.length < 2) return true;
        int pos = nums.length - 2, dst = nums.length-1;
        while (pos > 0) {
            if (pos + nums[pos] >= dst) {
                dst = pos;
            }
            pos--;
        }
        return pos + nums[pos] >= dst;
    }

    // max 为最远可以抵达的位置
    public boolean canJump5(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i]+i, max);
        }
        return true;
    }

    public void printList(int[] nums) {
        System.out.print("[");
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(" ," + nums[i]);
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump4(new int[]{2,0}));
        //System.out.println(jg.canJump3(new int[]{3,2,1,0,4}));
        //System.out.println(jg.canJump2(new int[]{3,2,1,0,4}, 0));
        //System.out.println(jg.canJump2(new int[]{0,2,3,4,5}, 0));
    }
}
