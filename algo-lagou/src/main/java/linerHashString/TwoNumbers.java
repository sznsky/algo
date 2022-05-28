package linerHashString;

import java.util.Arrays;

/**
 * @Describe : 两数相加
 * @Author : sunzhenning
 * @Since : 2022/5/25 11:52
 */
/**
 * nums = [2,7,11,15], target = 9
 * [0,1]
 */
public class TwoNumbers {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] result = twoSum(nums,27);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 使用map解法：时间复杂O(n)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumOfMap(int[] nums, int target){


        return null;
    }


    /**
     * 常规解法：这种时间复杂度O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for(int i = 0; i<nums.length;i++){
            int firstNum = nums[i];
            for(int j=i+1;j<nums.length;j++){
                int secondNum = nums[j];
                int sum = firstNum + secondNum;
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
