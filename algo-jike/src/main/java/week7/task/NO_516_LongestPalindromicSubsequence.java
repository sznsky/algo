package week7.task;

/**
 * 516. 最长回文子序列
 */
public class NO_516_LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        // dp 数组全部初始化为 0
        int[][] dp = new int[N][N];
        // base case
        for (int i = 0; i < N; i++)
            dp[i][i] = 1;
        // 反着遍历保证正确的状态转移
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                //回文子串
                if (s.charAt(i) == s.charAt(j))
                    //加2是因为新产生的i和j也是回文子串，长度加2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][N - 1];
    }
}
