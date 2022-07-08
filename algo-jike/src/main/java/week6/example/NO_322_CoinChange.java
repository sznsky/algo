package week6.example;

import java.util.Arrays;

/**
 * leetcode:322. 零钱兑换
 */
public class NO_322_CoinChange {

    public static void main(String[] args) {
        NO_322_CoinChange coinChange = new NO_322_CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int ans = coinChange.coinChange(coins,amount);
        System.out.println(ans);
    }

    public int coinChange(int[] coins, int amount) {
        //边界值
        int INF = (int)1e5;
        //存放局部的最优解
        int[] opt = new int[amount+1];
        //占位值，opt[i]刚好存放第i值,可以不设置
        opt[0] = 0;
        //扫描金额
        for(int i=1;i<=amount;i++){
            //将边界值存放
            opt[i] = INF;
            //扫描币种面额
            for(int j = 0;j<coins.length;j++){
                if(i - coins[j] >= 0){
                    //核心：状态转移方程，其实记录了1-amount每个最佳的组成币种数
                    opt[i] = Math.min(opt[i], opt[i-coins[j]]+1);
                }
            }
        }
        //大于等于边界值，不存在
        if(opt[amount] >= INF){
           opt[amount] = -1;
        }
        System.out.println(Arrays.toString(opt));
        return opt[amount];
    }

}
