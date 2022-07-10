package week6.task;

import java.util.List;

/**
 * leetcode:120. 三角形最小路径和
 */
public class NO_120_Triangle {

    /**
     * 思路：递归+缓存（记忆缓存）
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0,dp);
    }

    /**
     * 深度遍历
     * @param triangle
     * @param i
     * @param j
     * @param dp
     * @return
     */
    private int dfs(List<List<Integer>> triangle, int i, int j,int[][] dp) {
        if (i == triangle.size()) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        return dp[i][j] = Math.min(dfs(triangle, i + 1, j,dp),
                dfs(triangle, i + 1, j + 1,dp)) + triangle.get(i).get(j);
    }

}
