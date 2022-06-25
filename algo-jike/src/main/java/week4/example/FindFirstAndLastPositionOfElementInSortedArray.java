package week4.example;

import java.util.Arrays;

/**
 * leetcode:34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 思路：二分不等式的前驱和后继综合运用
 *给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray sortedArray =
                new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {2,2};
        int target  = 8;
        int[] ans = sortedArray.searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 思路：分析目标值开始和结束的位置
     * 1.目标值开始的位置：就是第一个大于等于target的位置，后继类型
     * 2.目标值结束的位置：就是最后一个小于等于target的位置，前驱类型
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        //>=target,后继类型
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left+right)/2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        ans[0] = right;

        //<=target前驱类型
        left = -1;
        right = nums.length - 1;
        while (left < right){
            //向上取整
            int mid = (left + right +1)/2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid -1;
            }
        }
        ans[1] = right;
        //无解的情况
        if(ans[0] > ans[1]){
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

}
