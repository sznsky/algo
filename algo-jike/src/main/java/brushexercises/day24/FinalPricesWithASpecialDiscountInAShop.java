package brushexercises.day24;

import java.util.Arrays;

/**
 * @Describe :leetcode:1475. 商品折扣后的最终价格
 * @Author : sunzhenning
 * @Since : 2022/6/22 18:26
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 */
public class FinalPricesWithASpecialDiscountInAShop {

    public static void main(String[] args) {
        FinalPricesWithASpecialDiscountInAShop discountInAShop = new FinalPricesWithASpecialDiscountInAShop();
        int[] prices = {10,1,1,6};
        int[] ans = discountInAShop.finalPrices1(prices);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 思路：1.双层for循环，和后面的价格比较，如果大于，就扣减，break,赋值给ans
     * 2.如果没有发生扣减，则保持原来的价格
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            boolean flag = false;
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] >= prices[j]){
                    flag = true;
                    ans[i] = prices[i]-prices[j];
                    break;
                }
            }
            if(!flag){
                ans[i] = prices[i];
            }
        }
        return ans;
    }

    /**
     * 优化思路
     * @param prices
     * @return
     */
    public int[] finalPrices1(int[] prices) {
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] >= prices[j]){
                    prices[i] = prices[i]-prices[j];
                    break;
                }
            }
        }
        return prices;
    }

}
