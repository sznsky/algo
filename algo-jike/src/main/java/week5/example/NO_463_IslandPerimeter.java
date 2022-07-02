package week5.example;

/**
 * leetcode:463. 岛屿的周长
 */
public class NO_463_IslandPerimeter {

    public static void main(String[] args) {
        NO_463_IslandPerimeter perimeter = new NO_463_IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int ans = perimeter.islandPerimeter(grid);
        System.out.println(ans);
    }

    /**
     * 思路：网格模板+求周长
     * 1.如果(r,c)出界，就是为这个岛屿贡献了一个黄边
     * 2.如果（r，c）=0，就是海洋，就是为这个岛屿贡献了一个绿边
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                //只有是岛屿的情况下，才去遍历他的前后左右
                if(grid[r][c] == 1){
                    //只有一个岛屿，直接返回
                    return dfs(grid,r,c);
                }
            }
        }
        return ans;
    }

    //dfd模板，同时对模板改造：1.如果(r,c)出界，就是为这个岛屿贡献了一个黄边，2.如果（r，c）=0，就是海洋，就是为这个岛屿贡献了一个绿边
    int dfs(int[][] grid,int r,int c){
        //不在网格内,贡献了一个黄边
        if(!isInArea(grid,r,c)){
            return 1;
        }
        //遇到海水，贡献了绿边
        if(grid[r][c] == 0){
            return 1;
        }
        //去重，已经遍历过的
        if(grid[r][c] != 1){
            return 0;
        }
        //给刚刚遍历过的赋值
        grid[r][c] = 2;
        //遍历坐标（r,c）的前后左右位置
        return dfs(grid,r-1,c)+
        dfs(grid,r+1,c)+
        dfs(grid,r,c-1)+
        dfs(grid,r,c+1);
    }

    /**
     * 判断坐标(r,c)是否在网格内
     * @param grid
     * @param r
     * @param c
     * @return
     */
    boolean isInArea(int[][] grid,int r,int c){
        //1，判断是否在网格内
        boolean rBoolean = r>=0 && r<grid.length;
        //2.判断c是否在网格内
        boolean cBoolean = c>=0 && c<grid[0].length;
        //综合
        return rBoolean && cBoolean;
    }

}
