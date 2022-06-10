package brushexercises.day12;

/**
 * @Describe : leetcode:70. 爬楼梯
 * @Author : sunzhenning
 * @Since : 2022/6/9 12:27
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 分析：台阶：n=1 需要的方法：1
 *             2            2（走一步，走两次；一次走两步）
 *             3            3（走一步，走三次;先走一步，再走走两步；先走两步，再走一步）
 *             4            5（走一步，走四次;走两步，走两次;先走一步，再走两步，再走一步;先走一步，再走一步，再走两步；先走两步，再走一次，再走一次）
 *             f(n) = f(n-1)+f(n-2)
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }

    /**
     * 动态规划实现
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int fn1 = 0;
        int fn2 = 1;
        int result = 0;
        for(int i=1;i<=n;i++){
            //状态转移
            result = fn2 + fn1;
            fn1 = fn2;
            fn2 = result;
        }
        return result;
    }

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

}
