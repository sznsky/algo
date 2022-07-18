package week7.task;

/**
 * 45. 跳跃游戏 II
 */
public class NO_45_JumpGameII {

    public static void main(String[] args) {
        NO_45_JumpGameII jumpGameII = new NO_45_JumpGameII();
        int[] nums = {2,3,1,1,4};
        int ans = jumpGameII.jump(nums);
        System.out.println(ans);
    }

    /**
     * 动态规划思路：将最小的步数存储起来
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int N = nums.length;
        //这里不需要加1，因为下标0到1就是一步
        int[] dp = new int[N];
        dp[0] = 0;
        for(int i=1;i<N;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<N;i++){
            int step = nums[i];
            for(int j=1;j<=step && j+i<nums.length;j++){
                dp[j + i] = Math.min(dp[j + i], dp[i] + 1);
            }
        }
        return dp[N-1];
    }
}
