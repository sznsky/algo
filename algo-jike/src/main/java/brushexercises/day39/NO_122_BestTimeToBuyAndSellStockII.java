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
        int ans = bestTimeToBuyAndSellStockII.maxProfit(prices);
        System.out.println(ans);
    }

    /**
     * 预言家：往后看一天，
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


}
