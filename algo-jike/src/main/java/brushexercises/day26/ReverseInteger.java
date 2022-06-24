package brushexercises.day26;

/**
 * @Describe : leetcode:7. 整数反转
 * @Author : sunzhenning
 * @Since : 2022/6/24 19:17
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = Integer.MIN_VALUE;
        System.out.println(reverseInteger.reverse(x));
    }

    /**
     * 思路:
     * 1.最好不要使用字符串反转，很多问题解决不了
     * 2.例如：1234%10=4;12345%10=5
     * 3.例如：1234/10 = 123；12345/10=1234
     * 4.注意int的范围
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int temp = x%10;
            //int的最大值：2^31-1 即：2147483647,除以10，即214748364,如果大于这个值，最小也是214748365，乘10，溢出；等于的情况见下面
            if((ans > Integer.MAX_VALUE/10 ) || (ans == Integer.MAX_VALUE/10 && temp > 7)){
                return 0;
            }
            //int的最小值：-2^31 即：-2147483648,除以10，即-214748364,如果小于这个值，最小也是-214748365，乘10，溢出；等于的情况见下面
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && temp < -8)){
                return 0;
            }
            ans = ans * 10 +temp;
            x = x/10;
        }
        return ans;
    }
}
