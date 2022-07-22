package brushexercises.day53;

/**
 * @Describe : 省份数量-547
 * @Author : sunzhenning
 * @Since : 2022/7/22 10:27
 */
public class NO_547_NumberOfProvinces {

    public static void main(String[] args) {
        NO_547_NumberOfProvinces numberOfProvinces = new NO_547_NumberOfProvinces();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int ans = numberOfProvinces.findCircleNum(isConnected);
        System.out.println(ans);
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int ret = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(int[][] isConnected,boolean[] visited,int i){
        for(int j = 0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,j);
            }
        }
    }

}
