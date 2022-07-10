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
        //加缓存
        int[] dp = new int[n+1];
        return climb(n,dp);
    }

    public int climb(int n,int[] dp){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //已经走过的，直接返回
        if(n>0 && dp[n] != 0 ){
            return dp[n];
        }
        int ans = climb(n-1,dp) + climb(n-2,dp);
        //给刚刚走过的步数储存起来
        dp[n] = ans;
        return ans;
    }

}
