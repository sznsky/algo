package preview;

/**
 * @Describe : f(x)=f(x-1)+x;其中 f(0)=1;求f(100)
 * @Author : sunzhenning
 * @Since : 2022/6/2 16:57
 */
public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        int x = 100;
        int result = recursion.function(x);
        System.out.println(result);
    }

    public int function(int x){
        if(x>0){
            return function(x-1) +x;
        }else{
            return 1;
        }
    }
}
