package brushexercises.day42;

/**
 * @Describe : 53. 最大子数组和
 * @Author : sunzhenning
 * @Since : 2022/7/12 9:16
 */
public class NO_53_MaximumSubarray {

    public static void main(String[] args) {
        NO_53_MaximumSubarray maximumSubarray = new NO_53_MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maximumSubarray.maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        int preMax = 0;
        int ans = nums[0];
        for(int i=0;i<nums.length;i++){
            preMax = Math.max(preMax+nums[i],nums[i]);
            ans = Math.max(ans,preMax);
        }
        return ans;
    }
}
