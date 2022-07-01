package week5.example;

import java.util.Arrays;

/**
 * leetcode:215. 数组中的第K个最大元素
 */
public class NO_215_KthLargestElementInAnArray {

    /**
     * 朴素解法：倒序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
