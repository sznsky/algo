package brushexercises.day34;

public class GuessGame {

    public int pick = 6;

    public int guess(int num){
        if(num > pick){
            return -1;
        }else if(num < pick){
            return 1;
        }else{
            return 0;
        }
    }
}
