package week6.task;

/**
 * leetcode:70. 爬楼梯
 */
public class NO_70_ClimbingStairs {

    public static void main(String[] args) {
        NO_70_ClimbingStairs climbingStairs = new NO_70_ClimbingStairs();
        int n = 3;
        int ans = climbingStairs.climbStairs(n);
        System.out.println(ans);
    }

    /**
     * 思路：斐波拉契递归+缓存
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            //状态转移方程：当前步数=前一步+前两步的步数总和
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
