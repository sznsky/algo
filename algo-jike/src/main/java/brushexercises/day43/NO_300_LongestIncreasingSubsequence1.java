package brushexercises.day43;

import java.util.Arrays;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/7/12 15:13
 *  * 输入：nums = [10,9,2,5,3,7,101,18]
 *  * 输出：4
 *  * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
 */
public class NO_300_LongestIncreasingSubsequence1 {

    public static void main(String[] args) {
        NO_300_LongestIncreasingSubsequence1 longestIncreasingSubsequence1 = new NO_300_LongestIncreasingSubsequence1();
        int[] nums = {10,9,2,5,3,7,101,18};
        int ans = longestIncreasingSubsequence1.lengthOfLIS(nums);
        System.out.println(ans);
    }


    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2){
            return 1;
        }
        int N = nums.length;
        int[] dp = new int[N];
        //使用1填充
        Arrays.fill(dp,1);
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    //数字i的前置最大递增元素的数量
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //找出最大的递增数
        int ans = 0;
        for(int i=0;i<dp.length;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
