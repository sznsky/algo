package brushexercises.day47;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/7/15 18:28
 */
public class NO_509_FibonacciNumber {


    public int fibDP(int n) {
       int[] dp = new int[n];
       return 0;

    }

    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
