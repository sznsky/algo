package brushexercises.day11;

import java.util.Arrays;

/**
 * @Describe : leetcode:303 区域和检索 - 数组不可变
 * @Author : sunzhenning
 * @Since : 2022/6/8 17:37
 * 思路：前缀求和解法，将当前元素前面的元素累加。
 */
public class NumArray1 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray1 numArray1 = new NumArray1(nums);
        System.out.println(Arrays.toString(numArray1.sums));
    }

    private int[] sums;

    public NumArray1(int[] nums) {
        this.sums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                sums[i] = nums[0];
            }else{
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0){
            return sums[right];
        }
        return sums[right]-sums[left-1];
    }
}
