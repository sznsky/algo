package brushexercises.day8;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode:1 【两数之和】
 * 思路：1.暴力解法：将前一个数和后一个数两两比较，找出目标值的下标
 * 2.使用map存储部分值
 */
public class TwoSum {

    public int[] twoSumOfMap1(int[] nums,int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    /**
     * 暴力解法
     * 时间复杂度是O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 使用map解法-优化解法
     * 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOfMap(int[] nums, int target) {
        //存两个符合条件元素的下标
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int num =  nums[i];
           if(map.containsKey(target - nums[i])){
               result[0] = map.get(target - nums[i]);
               result[1] = i;
               return result;
           }
           map.put(num, i);
        }
        return result;
    }

}
