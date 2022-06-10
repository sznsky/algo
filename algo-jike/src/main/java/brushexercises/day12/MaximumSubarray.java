package brushexercises.day12;

/**
 * @Describe : 53. 最大子数组和
 * @Author : sunzhenning
 * @Since : 2022/6/9 10:21
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]+nums[i-1] > nums[i]){
                nums[i] = nums[i]+nums[i-1];
            }
            if(nums[i] > ans){
                ans = nums[i];
            }
        }
        return ans;
    }
}
