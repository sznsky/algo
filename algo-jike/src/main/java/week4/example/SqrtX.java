package week4.example;

/**
 * leetcode:69. x 的平方根
 * 求x平方根
 * 思路：由于不能使用函数库，可以采用二分查找
 * （1）比如；4是右2*2的到的，4个平方根就是2，可以这样想，
 * 其实就是找最大的ans,ans*ans<=x,ans=1，显然不是最大，ans=2符合要求
 * （2）比如：求8的平方根。ans*ans<=8,ans=1,ans=2，ans=3的过程中，ans=3大了，ans=1小了，由于结果取整，因此ans=2就是最终结果
 */
public class    SqrtX {

    public static void main(String[] args) {
        SqrtX q = new SqrtX();
        int x = 1;
        int ans = q.mySqrtNew(x);
        System.out.println(ans);
    }

    /**
     * 思路：这个题目就是取一个<=target的数，也就是小数中取大的。适用于1.2前驱型
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //找到左右边界
        int left  = 0;
        int right = x;
        while(left < right){
            //需要向上取整
            int mid = (left+right+1)/2;
            //注意：这样写 x >= mid * mid，容易超出边界范围
            if(x/mid >= mid){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return right;
    }

    /**
     * 传统的二分查找，没有向上取整
     * @param x
     * @return
     */
    public int mySqrtNew(int x) {
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        //找到左右边界
        int left  = 0;
        int right = x;
        int ans = 0;
        while(left <= right){
            //防止int溢出
            int mid = left+(right-left)/2;
            if(mid == 0){
                return ans;
            }
            //注意：这样写 x >= mid * mid，容易超出边界范围
            if(x/mid >= mid){
                left = mid+1;
                ans = Math.max(ans, mid);
            }else{
                right = mid-1;
            }
        }
        return ans;
    }

}
