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
 * 思路：归纳动态方程
 */
public class Zuo_PlayingCards3 {

    public static void main(String[] args) {
        int[] arr = {5,7,4,5,8,1,6,0,3,4,6,1,7};
        long t1 = System.currentTimeMillis();
        int ans = win(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(ans+":"+(t2-t1));
    }


    public static int win(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        //加缓存：给二维数组赋初始值
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] gMap = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                fMap[i][j] = -1;
                gMap[i][j] = -1;
            }
        }
        int first = f(arr,0,arr.length-1,fMap,gMap);
        int second = g(arr,0 ,arr.length-1,fMap,gMap);
        return Math.max(first,second);
    }

    //先手拿牌
    public static int f(int[] arr,int L,int R,int[][] fMap,int[][] gMap){
        if(fMap[L][R] != -1){
            return fMap[L][R];
        }
        int ans;
        if(L == R){
            ans = 0;
        }else{
            int p1 = arr[L] + g(arr,L+1,R,fMap,gMap);
            int p2 = arr[R] + g(arr,L,R-1,fMap,gMap);
            ans  = Math.max(p1,p2);
        }
        fMap[L][R] = ans;
        return ans;
    }

    //后手拿牌
    public static int g(int[] arr,int L,int R,int[][] fMap,int[][] gMap){
        if(gMap[L][R] != -1){
            return gMap[L][R];
        }
        int ans = 0;
        if(L == R){
            ans = 0;
        }else{
            int p1 = f(arr,L+1,R,fMap,gMap);
            int p2 = f(arr,L,R-1,fMap,gMap);
            ans = Math.min(p1,p2);
        }
        gMap[L][R] = ans;
        return ans;
    }

}
