package brushexercises.day54;

import java.util.Arrays;

/**
 * @Describe :1334. 阈值距离内邻居最少的城市
 * @Author : sunzhenning
 * @Since : 2022/7/22 16:44
 * Floyd 核心代码: D[i][j]=min(D[i,k]+D[k,j],D[i,j])
 */
public class NO_1334 {

    public static void main(String[] args) {
        NO_1334 no_1334 = new NO_1334();
        int n = 5;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2;
        int ans = no_1334.findTheCity(n,edges,distanceThreshold);
        System.out.println(ans);
    }

    private void floyd(int[][] distances, int n){
        for(int k=0;k<n;k++){
            //n个顶点依次作为插入点
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i == j){
                        continue;
                    }
                    //动态转移方程：求出最短距离
                    distances[i][j] = Math.min(distances[i][k]+distances[k][j],distances[i][j]);
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 定义邻接矩阵D，并初始化各个城市之间的距离为int的最大值
        int[][] distances = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distances[i],Integer.MAX_VALUE/4);
        }
        for (int i=0; i<n; i++) {
            distances[i][i] = 0; //自身到自身的距离为0
        }

        //根据edges[][]初始化D[][]
        for(int i=0;i<n;i++){
            int[] e = edges[i];
            //无向图两个城市之间的距离相同
            int u = e[0],v = e[1], w = e[2];
            distances[u][v] = w;
            distances[v][u] = w;
        }
        //Floyd算法
        floyd(distances,n);

        //选择能够达到的其他城市，最少的城市，如果最少的城市有多个，选择序号最大的城市【有点别扭】
        int idx = 0;
        int minCount = 101;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (distances[i][j]<=distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                idx = i;
            }
        }
        return idx;
    }
}
