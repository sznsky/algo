package week9.example;

/**
 * 53. 最大子数组和
 */
public class NO_53_MaximumSubarray {


    public static void main(String[] args) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        NO_53_MaximumSubarray maximumSubarray = new NO_53_MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maximumSubarray.maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //前缀和
        int[] s = new int[n+1];
        //前置最小值
        int[] preMin = new int[n+1];
        for(int i=1;i<=n;i++){
            //前缀和
            s[i] = s[i-1] + nums[i-1];
        }
        for(int i=1;i<=n;i++){
            //最小前缀和
            preMin[i] = Math.min(preMin[i-1], s[i]);
        }
        int ans = -100000;
        for(int i=1;i<=n;i++){
            //在i之前（0-（i-1）里面）找到一个j,使得s[i]-s[j]最大
            ans = Math.max(ans,s[i] - preMin[i-1]);
        }
        return ans;
    }
}
