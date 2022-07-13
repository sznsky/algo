package brushexercises.day45;

/**
 * 121. 买卖股票的最佳时机
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/7/13 14:21
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 */
public class BestTimeToBuyAndSellStock {


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        int ans = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(ans);
    }

    /**
     * 思路：维护一个利润差的前置最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        //前一天可以获取到最大利润
        int pre = 0;
        for(int i=1;i<prices.length;i++){
            //利润差
            int diff = prices[i]-prices[i-1];
            //只要能获取利润，就把利润加起来，放到pre中
            pre = Math.max(pre+diff,0);
            ans = Math.max(ans,pre);
        }
        return ans;
    }

}
