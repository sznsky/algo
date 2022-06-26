package week4.example;

public class GuessGame {

    /**
     * 选择的数字
     */
    public int pick = 7;

    /**
     * 猜数字
     * @param num 所猜的的数字
     * @return
     */
    public int guess(int num){
        //pick比猜的数字小
        if(pick< num){
            return -1;
            //pick比猜的数字大
        }else if(pick > num){
            return 1;
        }else{
            //pick等于猜的数字
            return 0;
        }
    }
}
