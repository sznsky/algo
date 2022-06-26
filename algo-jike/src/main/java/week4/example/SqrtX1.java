package week4.example;

/**
 * leetcode:69. x 的平方根
 * 求x平方根
 * 思路：由于不能使用函数库，可以采用二分查找
 * （1）比如；4是右2*2的到的，4个平方根就是2，可以这样想，
 * 其实就是找最大的ans,ans*ans<=x,ans=1，显然不是最大，ans=2符合要求
 * （2）比如：求8的平方根。ans*ans<=8,ans=1,ans=2，ans=3的过程中，ans=3大了，ans=1小了，由于结果取整，因此ans=2就是最终结果
 */
public class SqrtX1 {

    public static void main(String[] args) {
        SqrtX1 sqrtX1 = new SqrtX1();
        int x = 8;
        int ans = sqrtX1.mySqrt(x);
        System.out.println(ans);
    }

    public int mySqrt(int x) {
        int ans = (int)myRealSqrt(x);
        return ans;
    }


    /**
     * 思路：这个题目就是取一个<=target的数，也就是小数中取大的。适用于1.2前驱型
     * 我们使用double类型来解决
     * @param x
     * @return
     */
        public double myRealSqrt(int x) {
        double left = 0;
        double right = x;
        //相减的结果，小数点后面保留7位数
        while(right - left > 1e-7){
            double mid = (left + right)/2;
            if(mid * mid < x){
                left = mid;
            }else{
                right = mid;
            }
        }
      return right;
    }

}
