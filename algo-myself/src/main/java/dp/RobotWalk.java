package dp;

/**
 * 机器人行走：常规搜索
 * 题意：假设有排成一排的N个位置，记为1-N,N>=2。开始时候机器人在M位置（M一定是1-N中的一个）
 * 如果机器人来到1的位置，那么下一步只能到2的位置；
 * 如果机器人来到N的位置，那么下一步只能来带N-1的位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人只能走K步，最终能到P的位置（P也是-1N中的一个）的有多少种？
 * 给定四个参数，N,M,k,P返回方法数
 */
public class RobotWalk {


    public static void main(String[] args) {
        System.out.println(ways1(4,2,4,4));
        System.out.println(ways2(4,2,4,4));
        System.out.println(ways3(4,2,4,4));
    }

    /**
     *
     * @param N 1-N个数
     * @param start 机器人开始的位置
     * @param aim 机器人要到的位置，即目的地
     * @param K 机器人要走的步数（走多少步到目的地）
     * @return
     */
    public static int ways1(int N,int start,int aim,int K){
        return process1(start,K,aim,N);
    }

    /**
     *
     * @param cur 机器人当前的位置
     * @param rest 机器人剩下多少步要走
     * @param aim 机器人的最终位置
     * @param N 总共就是1-N个数，就是1-N个位置
     * @return 机器人在cur位置出发，走过rest步之后，最终停在aim位置的方法数，是多少
     */
    public static int process1(int cur,int rest,int aim,int N){
        //机器人走了k步，走完了，如果刚好到终点aim位置，这种走法是需要的，返回1，
        // 否则走了k步，没有到终点位置，那么这种走好是不符合要求的
        if(rest == 0){
            return cur == aim ? 1:0;
        }
        //rest>0
        if(cur == 1){
            process1(2,rest-1,aim,N);
        }
        if(cur == N){
            process1(N-1,rest-1,aim,N);
        }
        return process1(cur-1,rest-1,aim,N)+process1(cur+1,rest-1,aim,N);
    }

    /**
     * 优化：加上缓存，也就是动态规划了
     * @param N
     * @param start
     * @param aim
     * @param K
     * @return
     */
    public static int ways2(int N,int start,int aim,int K){
        //创建缓存
        int[][] dp = new int[N+1][K+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=K;j++){
                dp[i][j] = -1;
            }
        }
        return process2(start,K,aim,N,dp);
    }

    public static int process2(int cur,int rest,int aim,int N,int[][] dp){
        //之前计算过
        if(dp[cur][rest] !=-1){
            return dp[cur][rest];
        }
        //之前没有计算过
        int ans;
        if(rest == 0){
            ans = cur == aim ?1:0;
        }else if(cur == 1){
            ans = process2(2,rest-1,aim,N,dp);
        }else if(cur == N){
            ans = process2(N-1,rest-1,aim,N,dp);
        }else{
            ans = process2(cur-1,rest-1,aim,N,dp)+process2(cur+1,rest-1,aim,N,dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    /**
     * 标准的动态规划
     * @param N
     * @param start
     * @param aim
     * @param K
     * @return
     */
    public static int ways3(int N,int start,int aim,int K){
        int[][] dp = new int[N+1][K+1];
        dp[aim][0] = 1;
        //列
        for(int rest = 1;rest<=K;rest++){
            dp[1][rest] = dp[2][rest-1];
            //行
            for(int cur = 2;cur<N;cur++){
                dp[cur][rest] = dp[cur-1][rest-1] + dp[cur+1][rest-1];
            }
            dp[N][rest] = dp[N-1][rest-1];
        }
        return dp[start][K];
    }



}
