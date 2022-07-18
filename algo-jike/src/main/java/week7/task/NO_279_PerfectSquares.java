package week7.task;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class NO_279_PerfectSquares {

    /**
     * 思路：和零钱兑换是一样的
     * 为了凑出i,需要i-squares[i]+1
     * @param n
     * @return
     */
    public int numSquares(int n) {
        //1.对n开方，求出平方根
        int root = (int) Math.sqrt(n);
        //2.找出平方小于等于n的所有数
        int[] squares = new int[root];
        for (int x = 1; x <= root; x++) {
            squares[x - 1] = x * x;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = n + 1;
            for (int sq : squares) {
                if (i >= sq) {
                    //动态转移方程；要凑出i,需要i-squares[i]+1，借鉴【322题】找零兑换
                    dp[i] = Math.min(dp[i], dp[i - sq] + 1);
                }
            }
        }
        return dp[n];
    }


}
