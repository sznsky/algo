package brushexercises.day32;

/**
 * @Describe : 69. x 的平方根
 * @Author : sunzhenning
 * @Since : 2022/6/30 11:18
 */
public class NO_69_SqrtX1 {

    public static void main(String[] args) {
        NO_69_SqrtX1 sqrtX = new NO_69_SqrtX1();
        int x = 2147483647;
        int ans = sqrtX.mySqrt(x);
        System.out.println(ans);
    }

    /**
     * 二分不等式：前驱类型，<=
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x==0 || x ==1){
            return x;
        }
        double left = 0;
        double right = x;
        while(right - left >= 1e-7){
            //前驱类型向上取整
            double mid = (right+left)/2;
            if(x/mid >= mid){
                left = mid;
            }else{
                right = mid;
            }
        }
        return (int)right;
    }
}
