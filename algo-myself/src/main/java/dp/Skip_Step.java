package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 一次上楼梯可以一步，可以两步，一个楼梯有N级阶梯，请问上楼梯的方法有多少？
 * 1.定义数组的含义，比如定义db[i],表示i级阶梯总共有db[i]种跳法，那么n级阶梯总共有db[n]种跳法。db[n]就是我们要的结果。
 * 2.找出数组元素之间的的关系式。
 */
public class Skip_Step {

    public static void main(String[] args) {
        int n = 10;
        long t1 = System.currentTimeMillis();
        System.out.println(dp(n));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

        long t3 = System.currentTimeMillis();
        System.out.println(recursionNew(n));
        long t4 = System.currentTimeMillis();
        System.out.println(t4-t3);

        long t5 = System.currentTimeMillis();
        System.out.println(recursion(n));
        long t6 = System.currentTimeMillis();
        System.out.println(t6-t5);
    }

    /**
     * * 动态规划的方法解决
     * @param n
     * @return
     */
    public static int dp(int n){
        if(n <= 1){
            return n;
        }
        //因为n是从0开始的，所以要存放n个长度数组，需要n+1长度数组
        int[] dp = new int[n+1];
        //注意初始值，初始值是不能使用公式的
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //下面就是找规律，其实就是数学归纳法，注意成立的条件
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 递归的方法解决:f(n) = f(n-1) + f(n-2)
     * @return
     */
    public static int recursion(int n){
        if(n <= 2){
            return n;
        }
       return recursion(n-1) + recursion(n-2);
    }


    /**
     * 递归的方法解决:f(n) = f(n-1) + f(n-2)
     * 带备忘录的递归解决，使用一个Map存储一下中间的结果
     * @return
     */
    private final static Map<Integer,Integer> map = new HashMap<>();
    public static int recursionNew(int n){
        if(n <= 2){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        return recursionNew(n-1) + recursion(n-2);
    }
}
