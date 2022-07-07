package brushexercises.day39;

/**
 * @Describe :121. 买卖股票的最佳时机
 * @Author : sunzhenning
 * @Since : 2022/7/7 18:48
 */
public class NO_121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        NO_121_BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new NO_121_BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        int ans = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(ans);
    }

    /**
     * 暴力搜索：超时，时间复杂度是O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                ans = Math.max(ans,prices[j]-prices[i]);
            }
        }
        return ans;
    }

    /**
     * 维护一个前置最大值数组
     * @param prices
     * @return
     */
    public int maxProfitStack(int[] prices) {
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                ans = Math.max(ans,prices[j]-prices[i]);
            }
        }
        return ans;
    }



}
