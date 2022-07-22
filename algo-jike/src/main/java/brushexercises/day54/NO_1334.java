package brushexercises.day54;

/**
 * @Describe :1334. 阈值距离内邻居最少的城市
 * @Author : sunzhenning
 * @Since : 2022/7/22 16:44
 * Floyd 核心代码: D[i][j]=min(D[i,k]+D[k,j],D[i,j])
 */
public class NO_1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 定义邻接矩阵D，并初始化各个城市之间的距离为int的最大值
        int[][] D = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                D[i][j] = Integer.MAX_VALUE;
            }
        }
        //根据edges[][]初始化D[][]
        for(int i=0;i<n;i++){
            int[] e = edges[i];
            //无向图两个城市之间的距离
            D[e[0]][e[1]] = e[2];
            D[e[1]][e[0]] = e[2];
        }
        //Floyd算法
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i == j || D[i][k] == Integer.MAX_VALUE || D[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    D[i][j] = Math.min(D[i][k]+D[k][j],D[i][j]);
                }
            }
        }
        //选择能够达到的其他城市，最少的城市，如果最少的城市有多个，选择序号最大的城市【有点别扭】
        int ans = 0;
        int minNum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i != j && D[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= minNum){
                minNum = cnt;
                ans = i;
            }
        }
        return ans;
    }
}
