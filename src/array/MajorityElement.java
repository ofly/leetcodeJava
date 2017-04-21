package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flex on 17-3-18.
 * no.169 Majority Element
 * no.229 Majority Element II
 * @author flex
 */

/* Problem: Given an array of size n, find the majority element. The majority
 * element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * Problem: Given an integer array of size n, find all elements that appear more
 * than ⌊n/3⌋ times. The algorithm should run in linear time and in O(1) space.
 * */
public class MajorityElement {

    // O(n), O(1)
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return nums[0];
        int candidate = nums[0];
        int cnt = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==candidate)
                cnt += 1;
            else if(cnt==0){
                candidate = nums[i];
                cnt = 1;
            }else{
                cnt -= 1;
            }
        }
        /*
        //check
        cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==candidate)
                cnt += 1;
        }
        */
        return candidate;


    }

    public List<Integer> majorityElementII(int[] nums) {
        List<Integer> results = new ArrayList<>();
        int candidate1=Integer.MAX_VALUE, candidate2=Integer.MAX_VALUE;
        int cnt1=0, cnt2=0;
        for (int i=0; i<nums.length; i++) {
            if(candidate1==nums[i])
                cnt1 += 1;
            else if(candidate2==nums[i])
                    cnt2+=1;
            else if(cnt1==0){
                candidate1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2==0){
                candidate2 = nums[i];
                cnt2 = 1;
            }else{
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }

        //check




        return results;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int[] {1, 0, 1, 1, 0, 1, 4, 5, 1}));
    }

}
