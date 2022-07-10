package dp;

/**
 * 左程云的算法课程：
 * 给定一个整数型的数组，代表数值不同的纸牌排成一条龙，
 * 玩家A和玩家B依次拿走每张牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每次玩家A和玩家B只能拿走最左的或者最右的牌
 * 玩家A和玩家B都是绝顶聪明的
 * 请返回最后胜者的分数
 *
 */
public class Zuo_PlayingCards {


    public static int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int first = f(arr,0,arr.length-1);
        int second = g(arr,0 ,arr.length-1);
        return Math.max(first,second);
    }

    //先手拿牌
    public static int f(int[] arr,int L,int R){
        if(L == R){
            return arr[L];
        }
        int p1 = arr[L] + g(arr,L+1,R);
        int p2 = arr[R] + g(arr,L,R-1);
        return Math.max(p1,p2);
    }

    //后手拿牌
    public static int g(int[] arr,int L,int R){
        if(L == R){
            return 0;
        }
        int p1 = f(arr,L+1,R);
        int p2 = f(arr,L,R-1);
        return Math.min(p1,p2);
    }

}
