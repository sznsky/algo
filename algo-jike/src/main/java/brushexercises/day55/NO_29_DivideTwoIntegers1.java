package brushexercises.day55;

/**
 * @Describe : 29. 两数相除
 * @Author : sunzhenning
 * @Since : 2022/7/23 14:03
 */
public class NO_29_DivideTwoIntegers1 {


    public static void main(String[] args) {
        NO_29_DivideTwoIntegers1 divideTwoIntegers = new NO_29_DivideTwoIntegers1();
        int dividend = -2147483648;
        int divisor = -1;
        int ans = divideTwoIntegers.divide(dividend, divisor);
        System.out.println(ans);
    }

    /**
     * 除法：
     * 朴素解法：不停的减被除数
     * @param dividend 被除数
     * @param divisor 除数
     * @return 返回值
     */
    public int divide(int dividend, int divisor) {
        //边界情况的处理，0的情况
        if(dividend == 0){
            return 0;
        }
        //除数是1
        if(divisor == 1){
            return dividend;
        }
        //除数-1
        if(divisor == -1){
            //被除数只要大于最小的数，返回他的相反数
            if(dividend > Integer.MIN_VALUE){
                return -dividend;
            }
            //被除数等于最小的数，直接返回最大的数
            return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if((a > 0 && b<0) || (a<0 && b > 0)){
            sign = -1;
        }
        //将a,b都转为正数
        a = a>0?a:-a;
        b = b>0?b:-b;
        long res = div(a,b);
        if(sign > 0){
            return (int)(res > Integer.MAX_VALUE?Integer.MAX_VALUE:res);
        }
       return (int)-res;
    }

    private int div(long a,long b){
        if(a < b){
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb + tb)<=a){
            count = count + count;
            tb = tb + tb;
        }
        return (int)(count + div(a - tb,b));
    }
}
