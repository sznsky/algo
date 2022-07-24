package brushexercises.day54;

import java.util.Arrays;

/**
 * @Describe :1334. 阈值距离内邻居最少的城市
 * @Author : sunzhenning
 * @Since : 2022/7/22 16:44
 * Floyd 核心代码: D[i][j]=min(D[i,k]+D[k,j],D[i,j])
 */
public class NO_1334_1 {

    public static void main(String[] args) {
        NO_1334_1 no_1334 = new NO_1334_1();
        int n = 5;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2;
        int ans = no_1334.findTheCity(n,edges,distanceThreshold);
        System.out.println(ans);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        final int N = Integer.MAX_VALUE/4;
        for(int i = 0;i<n;i++){
            Arrays.fill(dis[i],N);
        }
        for(int[] e:edges){
            dis[e[0]][e[1]] = e[2];
            dis[e[1]][e[0]] = e[2];
        }
        for(int k = 0; k<n; k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(i==j){
                        continue;
                    }
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        int min = 101,res = 0;
        for(int i = 0;i<n;i++){
            int cur = 0;
            for(int j = 0;j<n;j++){
                if(dis[i][j] <= distanceThreshold){
                    cur++;
                }
            }
            if(cur <= min){
                min = cur;
                res = i;
            }
        }
        return res;
    }
}
