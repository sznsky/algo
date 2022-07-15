package brushexercises.day46;

/**
 * @Describe : 122. 买卖股票的最佳时机 II
 * @Author : sunzhenning
 * @Since : 2022/7/14 14:52
 */
public class NO_122_BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        NO_122_BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new NO_122_BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        int ans = bestTimeToBuyAndSellStockII.maxProfit(prices);
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            ans = ans + Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }
}
