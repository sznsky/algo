package brushexercises.day53;

/**
 * @Describe : 547. 省份数量
 * @Author : sunzhenning
 * @Since : 2022/7/22 14:45
 * 思路：并查集
 * 并查集是一种数据结构：1.并代表合并，2.查代表查找，3.集代表是一个以字典为基础的数据结构
 */
public class NO_547_NumberOfProvinces1 {

    public static void main(String[] args) {
        NO_547_NumberOfProvinces1 numberOfProvinces1 = new NO_547_NumberOfProvinces1();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int ans = numberOfProvinces1.findCircleNum(isConnected);
        System.out.println(ans);
    }

    public int findCircleNum(int[][] isConnected) {
        //isConnected是无向图的邻接矩阵，n为无向图的定点数量
        int n = isConnected.length;
        //定义boolean数组标识顶点是否被访问
        boolean[] visited = new boolean[n];
        //定义count来累计遍历过的连通域的数量
        int count = 0;
        for(int i=0;i<n;i++){
            //如果当前顶点i未被访问，说明又是一个新的连接域，则遍历新的连通域，count = count+1
            if(!visited[i]){
                count ++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }

    private void dfs(int i,int[][] isConnected,boolean[] visited){
        //对当前节点i进行访问标记
        visited[i] = true;
        for(int j = 0;j<isConnected.length; j++){
            //对未遍历过的连接点继续遍历
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(j,isConnected,visited);
            }
        }
    }
}
