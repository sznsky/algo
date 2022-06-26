package week4.example;

/**
 * leetcode:374. 猜数字大小
 */
public class GuessNumberHigherOrLower extends GuessGame {

    public static void main(String[] args) {
        GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();
        int ans = guessNumberHigherOrLower.guessNumber(10);
        System.out.println(ans);
    }

    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        //循环到左右端点的区间相同
       while (left < right){
           //防止溢出，n的最大值是2^31-1，(left+right)容易超出int的边界，右下面的写法
           int mid = left +(right - left)/2;
           //所先择的数字pick比猜的数字mid小
           if(guess(mid) <=0){
               right = mid;
           }else{
               left = mid+1;
           }
       }
       //返回right
        return left;
    }

}
