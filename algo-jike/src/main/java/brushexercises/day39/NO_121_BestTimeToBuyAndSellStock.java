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
        int ans = bestTimeToBuyAndSellStock.maxProfitDP(prices);
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
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {


        return 0;
    }



    /**
     * 思路：动态规划，注意状态转移方程
     * 将第i天卖出的最大利润=第i-1天获得最大利润+利润差
     *
     * @param prices
     * @return
     */
    public int maxProfitDP1(int[] prices) {
        int length = prices.length;
        if(length < 2){
            return 0;
        }
        //最终结果
        int ans = 0;
        //前一天获取的最大利润
        int pre = 0;
        for(int i=1;i<length;i++){
            //利润差
            int diff = prices[i] - prices[i-1];
            //状态转移方程：将第i天卖出的最大利润=第i-1天获得最大利润+利润差
            pre = Math.max(pre+diff,0);
            //前一天和结果取大
            ans = Math.max(ans,pre);
        }
        return ans;
    }



}
