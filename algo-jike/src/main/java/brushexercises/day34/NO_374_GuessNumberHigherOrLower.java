package brushexercises.day34;

/**
 * leetcode:374. 猜数字大小
 */
public class NO_374_GuessNumberHigherOrLower extends GuessGame{

    public static void main(String[] args) {
        NO_374_GuessNumberHigherOrLower guessNumberHigherOrLower = new NO_374_GuessNumberHigherOrLower();
        int ans = guessNumberHigherOrLower.guessNumber(10);
        System.out.println(ans);

    }

    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left < right){
            int mid = left+(right-left)/2;
            if(guess(mid) <= 0){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

}
