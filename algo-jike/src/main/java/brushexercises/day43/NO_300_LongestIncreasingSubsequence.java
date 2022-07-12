package brushexercises.day43;

import java.util.Arrays;

/**
 * @Describe : 300. 最长递增子序列
 * @Author : sunzhenning
 * @Since : 2022/7/12 11:17
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
 */
public class NO_300_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        NO_300_LongestIncreasingSubsequence longestIncreasingSubsequence = new NO_300_LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        int ans = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(ans);
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //dp[i]维护i前置最大的递增元素的数量
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println("i:"+i+",dp[i]:"+dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
