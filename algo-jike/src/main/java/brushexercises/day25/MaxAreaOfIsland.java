package brushexercises.day25;

/**
 * @Describe :leetcode:695. 岛屿的最大面积
 * @Author : sunzhenning
 * @Since : 2022/6/23 18:31
 * 思路：岛屿问题遍历的模板
 */
public class MaxAreaOfIsland {


    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid =  {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int ans = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    /**
     * 获取面积最大的岛屿
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int r = 0;r < grid.length; r++){
            for(int c = 0;c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    //依次遍历岛屿的面积
                    int a = area(grid,r,c);
                    ans = Math.max(ans,a);
                }
            }
        }
        return ans;
    }

    /**
     * 根据岛屿的面积：0-海水 1-岛屿 2-遍历过的岛屿
     * @param grid
     * @param r
     * @param c
     * @return
     */
    int area(int[][] grid,int r,int c){
        if(!inArea(grid, r, c)){
            return 0;
        }
        if(grid[r][c] !=1){
            return 0;
        }
        //遍历过岛屿小格子的给2，防止重复遍历
        grid[r][c] = 2;
        return 1+
                area(grid, r-1,c) +
                area(grid, r+1,c) +
                area(grid, r,c-1) +
                area(grid, r,c+1);
    }

    /**
     * 判断一个格子是不是岛屿：
     * r行 c列
     * @param grid
     * @param r
     * @param c
     * @return
     */
    boolean inArea(int[][] grid,int r,int c){
        return r>=0 && r < grid.length && c>=0 && c < grid[0].length;
    }

}
