package week2.classroom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode:1 【两数之和】
 * 思路：1.暴力解法.分两层遍历数组，每一个元素和后面每一个元素相加，看看是否等于target，时间复杂度O(n^2)
 * 2.使用hashMap,只遍历一次,每次将元素的坐标和值存储起来，建立键值对关系。后续的遍历再去从map中查找。时间复杂度O(n)
 */
public class TwoSum {


    public static void main(String[] args) {
        //int[] nums = {2,7,11,15};
        int[] nums = {1,3,3,3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //key 是
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }


}
