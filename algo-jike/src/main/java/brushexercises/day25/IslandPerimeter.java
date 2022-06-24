package brushexercises.day25;

/**
 * @Describe : leetcode:463. 岛屿的周长
 * @Author : sunzhenning
 * @Since : 2022/6/24 14:23
 */
public class IslandPerimeter {

    /**
     * 遍历网格
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //岛屿
                if(grid[i][j] == 1){
                    //题目只有一个岛屿，计算一个即可
                    ans = ans + dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i,int j){
        //坐标(i,j)不在超出网格范围，对应了一个黄边
        if(!inArea( grid, i, j)){
            return 1;
        }
        //坐标（i,j）对应的一个海洋的格子，对应一条蓝色的边
        if(grid[i][j] == 0){
            return 1;
        }
        //(i,j)是已经遍历的陆地格子，和周长没有关系
        if(grid[i][j] != 1){
            return 0;
        }
        //给当前遍历过的给2
        grid[i][j] = 2;
        return dfs(grid,i-1,j) + dfs(grid,i+1,j)+ dfs(grid,i,j-1)+ dfs(grid,i,j+1);
    }

    /**
     * 判断(i,j)这个坐标的点是否在网格（grid）内
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private boolean inArea(int[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }

}
