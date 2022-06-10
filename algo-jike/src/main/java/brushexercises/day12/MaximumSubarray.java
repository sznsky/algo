package brushexercises.day12;

import java.util.Arrays;

/**
 * @Describe : 53. 最大子数组和
 * @Author : sunzhenning
 * @Since : 2022/6/9 10:21
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        //维护一个前置元素和大最大值
        int preMaxSum = 0;
        int ans = nums[0];
        for(int i=0;i<nums.length;i++){
            //如果(前置元素最大值+nums[i])还比当前nums[i]小，直接替换掉，之前值不可能最大
            preMaxSum = Math.max(nums[i]+preMaxSum,nums[i]);
            //存放的答案和前置最大值比较，取大
            ans = Math.max(ans,preMaxSum);
        }
        return ans;
    }

    public int maxSubArray1(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]+nums[i-1] > nums[i]){
                nums[i] = nums[i]+nums[i-1];
            }
            ans = Math.max(ans, nums[i]);
            System.out.println(Arrays.toString(nums));
        }
        return ans;
    }
}
