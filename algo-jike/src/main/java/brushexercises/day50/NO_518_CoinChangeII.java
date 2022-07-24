package brushexercises.day50;

/**
 * @Describe : 518. 零钱兑换 II
 * @Author : sunzhenning
 * @Since : 2022/7/20 20:58
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个.
 */
public class NO_518_CoinChangeII {

    public static void main(String[] args) {
        NO_518_CoinChangeII coinChangeII = new NO_518_CoinChangeII();
        int amount = 10;
        int[] coins = {10};
        int ans = coinChangeII.change(amount,coins);
        System.out.println(ans);
    }

    /**
     * 典型的背包问题
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
