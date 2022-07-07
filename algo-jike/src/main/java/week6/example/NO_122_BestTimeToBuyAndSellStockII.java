package week6.example;

/**
 * leetcode:122. 买卖股票的最佳时机 II
 */
public class NO_122_BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        NO_122_BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new NO_122_BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        int ans = bestTimeToBuyAndSellStockII.maxProfit1(prices);
        System.out.println(ans);
    }

    /**
     * 预言家：看后一天是涨还是跌，后一天跌，提前卖掉，后一天涨了，拿着不动
     * 现实生活不存在
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            ans = ans + Math.max(prices[i]-prices[i-1],0);
        }
        return ans;
    }

    /**
     * 这个更好理解，后一天和前一天比，跌了不要，涨了计算到ans中
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int ans = 0;
        for(int i=0;i<prices.length-1;i++){
            ans = ans + Math.max(prices[i+1]-prices[i],0);
        }
        return ans;
    }
}
