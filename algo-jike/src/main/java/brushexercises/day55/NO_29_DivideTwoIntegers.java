package brushexercises.day55;

/**
 * @Describe : 29. 两数相除
 * @Author : sunzhenning
 * @Since : 2022/7/23 14:03
 */
public class NO_29_DivideTwoIntegers {


    public static void main(String[] args) {
        NO_29_DivideTwoIntegers divideTwoIntegers = new NO_29_DivideTwoIntegers();
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
        boolean dividendFlag = true;
        boolean divisorFlag = true;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }
        if(dividend < 0){
            dividend = -dividend;
            dividendFlag = false;
        }
        if(divisor < 0){
            divisor = -divisor;
            divisorFlag = false;
        }
        int ans = 0;
        while (dividend >= divisor){
            dividend = dividend - divisor;
            ans++;
        }
        if(dividendFlag && divisorFlag){
            return ans;
        }else if(dividendFlag || divisorFlag){
            return -ans;
        }else{
            return ans;
        }
    }
}
