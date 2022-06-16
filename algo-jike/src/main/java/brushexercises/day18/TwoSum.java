package brushexercises.day18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode:1. 两数之和
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/16 14:05
 * nums = [2,7,11,15], target = 9
 * 解法思路：1.暴力解法，双层循环遍历，找出结果
 * 2.一使用次循环+map存储已经循环的数字,继续循环的时候，在map中找出数字
 * 3.本方法不适合使用双指针（对撞指针），原因是题目没有说是有序队列
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,11,7,15};
        int target = 9;
        //int[] ans = twoSum.twoSum(nums,target);
        int[] ans = twoSum.twoSumOfMap(nums,target);
        System.out.println(Arrays.toString(ans));
    }


    public int[] twoSumOfMap(int[] nums, int target) {
        int[] ans = new int[2];
        //map存储的是nums[i]和i
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }





    /**
     * 暴力解法，双层循环找出结果，时间复杂度O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] ==target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
