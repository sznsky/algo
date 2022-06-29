package brushexercises.day31;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Describe : leetcode:189. 轮转数组
 * @Author : sunzhenning
 * @Since : 2022/6/29 18:06
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class NO_189_RotateArray {

    public static void main(String[] args) {
        NO_189_RotateArray rotateArray = new NO_189_RotateArray();
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotateArray.rotate(nums, k);
       System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：暴力解法，倒数第二个数开始，一次给最后那个数，然后把倒数第一个数给到数组0的位置
     * O(n^2)的时间复杂度，超时
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(k ==0){
            return;
        }
        for(int i=0;i<k;i++){
            int last = nums[nums.length-1];
            for(int j=nums.length-2;j>=0;j--){
                nums[j+1] = nums[j];
            }
            nums[0] = last;
        }
    }

}
