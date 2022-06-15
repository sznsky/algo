package brushexercises.day18;

/**
 * @Describe : leetcode:50. Pow(x, n)
 * @Author : sunzhenning
 * @Since : 2022/6/15 15:53
 */
public class PowXN {

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(2.0,-3));
    }

    /**
     * 思路：1.分治算法，常规遍历累乘求解，效率低，容易超时
     * 2.分治折半（递归加上分治），折半后的结果，相乘，得到结果
     * 3.n为奇数的时候，需要注意,如int y = 5/2，y=2,结果会少乘一次，需要特别处理
     * 4.n为负数的时候，如： 5^(-3) = 1/(5^3)
     * 5.注意n的边界，-2^31 <= n <= 2^31-1,注意越界处理
     * 6.0的n次方都等于1
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        //如果n=-2^31 -n=2^31 超过了int范围，需要单独处理
        //取出int的最大值，然后再多乘一个x
        if(n == Integer.MIN_VALUE){
            return 1/(myPow(x, Integer.MAX_VALUE)*x);
        }
        if(n < 0){
            return 1/myPow(x, (-n));
        }
        double halfResult = myPow(x, n/2);
        double result = halfResult * halfResult;
        if(n%2 != 0){
            result = result * x;
        }
        return result;
    }

}
