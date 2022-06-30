package brushexercises.day32;

/**
 * @Describe : 69. x 的平方根
 * @Author : sunzhenning
 * @Since : 2022/6/30 11:18
 */
public class NO_69_SqrtX {

    public static void main(String[] args) {
        NO_69_SqrtX sqrtX = new NO_69_SqrtX();
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
        int left = 0;
        int right = x;
        while(left < right){
            //前驱类型向上取整
            int mid = (right+left+1)/2;
            if(x/mid >= mid){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return right;
    }
}
