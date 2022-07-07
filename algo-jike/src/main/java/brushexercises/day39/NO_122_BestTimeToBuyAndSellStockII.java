package brushexercises.day39;

/**
 * @Describe : leetcode:122. 买卖股票的最佳时机 II
 * @Author : sunzhenning
 * @Since : 2022/7/7 17:38
 */
public class NO_122_BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        NO_122_BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new NO_122_BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        int ans = bestTimeToBuyAndSellStockII.maxProfitDP1(prices);
        System.out.println(ans);
    }

    /**
     * 预言家思想：往后看一天，
     * 1）后一天对于前一天涨了，持有；
     * 2）后一天对于前一天跌了，卖出；
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        //和后一天比较，防止出界
        for(int i=0;i<prices.length-1;i++){
            //涨了，继续持有，涨幅增加值放到ans中
            if(prices[i+1] > prices[i]){
                ans = ans + (prices[i+1] - prices[i]);
            }else{
                //跌了，不持有
                ans = ans + 0;
            }
        }
        return ans;
    }

    /**
     * 动态规划思想：其实就是记忆化搜索。
     * 可以这样想：要想n天的收益最大化，那么n-1天的收益也是最大化的。将第n-1天的价格和n天的价格比较，涨了继续持有，跌了在n-1天的时候，已经卖出了，但是最终是要卖出
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {
        int length = prices.length;
        //没法比较涨跌
        if(length < 2){
            return 0;
        }
        //二维数组dp[i][j],这个二维数组表示，第i天，j这种状态下最大现金数。j=0表示持有现金，1表示持有股票
        int[][] dp = new int[length][2];
        //初始值，第0天，持有的现金为0，持有股票的金额prices[0],那么现金数就是-prices[0];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[length-1][0];
    }

    /**
     * 可以对上面的方法改造
     * @param prices
     * @return
     */
    public int maxProfitDP1(int[] prices) {
        int length = prices.length;
        //没法比较涨跌
        if(length < 2){
            return 0;
        }
        //二维数组dp[i][j],这个二维数组表示，第i天，j这种状态下最大现金数。j=0表示持有现金，1表示持有股票
        int[] stack = new int[length];
        int[] cash = new int[length];
        //初始值，第0天，持有的现金为0，持有股票的金额prices[0],那么现金数就是-prices[0];
        cash[0] = 0;
        stack[0] = -prices[0];
        for(int i=1;i<length;i++){
            cash[i] = Math.max(cash[i-1],stack[i-1]+prices[i]);
            stack[i] = Math.max(stack[i-1],cash[i-1]-prices[i]);
        }
        return cash[length-1];
    }




}
