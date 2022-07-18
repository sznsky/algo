package week7.example;

import java.util.Arrays;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
public class NO_122_bBestTimeToBuyAndSellStockII {
    /**
     * 动态规划解决
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //0,在数组的前面加上一个0
        int[] pricesNew = new int[prices.length+1];
        Arrays.copyOf(prices,1);

        int N = prices.length;

        //1.定义状态，求max初始化负无穷，求min初始化正无穷
        int[][] f = new int[N+1][N+1];

        return 0;
    }

}
