package week8.task;

/**
 * 200. 岛屿数量
 */
public class NO_200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c] == '1'){
                    if(dfs(grid,r,c)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    //岛屿的遍历模板:r表示行，c表示列
    boolean dfs(char[][] grid,int r,int c){
        if(!isInArea(grid,r,c)){
            return false;
        }
        //不是岛屿，直接结束
        if(grid[r][c] != '1'){
            return false;
        }
        //遍历过的岛屿的点给2
        grid[r][c] = '2';

        //遍历坐标（r,c）的前后上下左右
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        return true;
    }

    //判断坐标（r,c）是否在网格int[][] grid
    boolean isInArea(char[][] grid, int r,int c){
        //1.判断r是否在网格中
        boolean rBoolean = r>=0 && r < grid.length;
        //2.判断c在是否在网格中
        boolean cBoolean = c>=0 && c < grid[0].length;
        //综合，(c,r)在网格中的条件
        return rBoolean && cBoolean;
    }
}
