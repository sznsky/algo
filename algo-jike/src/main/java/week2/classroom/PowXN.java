package week2.classroom;

/**
 * leetcode:50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）.
 * 思路：1.常规的递归算法 2.分治算法
 */
public class PowXN {


    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        double ans = powXN.myPow1(2.00000,-2);
        System.out.println(ans);
    }

    /**
     * 分治算法
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == -(1l<<31)){
            //int的取值范围为[-2^31,2^31-1]，下面-(n+1)=2^31-1,那就少计算了一次，需要多加一次x
            return 1.0/(myPow1(x,-(n+1))*x);
        }
        if(n < 0){
            return 1.0/myPow1(x,-n);
        }
        double temp = myPow1(x, n/2);
        double ans = temp*temp;
        if(n % 2 == 1){
            ans = ans*x;
        }
        return ans;
    }


    /**
     * 传统朴素的解法：逐个遍历
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double ans = 0.0;
        if(n ==0){
            return 1;
        }
        if(n > 0){
            for(int i=0;i<n;i++){
                if(i == 0){
                    ans = x;
                }else{
                    ans = ans*x;
                }
            }
        }
        if(n < 0){
            n = -n;
            for(int i=0;i<n;i++){
                if(i == 0){
                    ans = x;
                }else{
                    ans = ans*x;
                }
            }
            ans = 1/ans;
        }
        return ans;
    }

}
