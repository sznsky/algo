package brushexercises.day25;

/**
 * @Describe : leetcode:463. 岛屿的周长
 * @Author : sunzhenning
 * @Since : 2022/6/24 15:04
 * 思路：之前采用的是dfs的遍历方式。现在只采用双层for遍历
 * 1.遍历网格，找出值为1的格子
 * 2.每个格子4条边。都加上去
 * 3.找出为1格子四周还有没有只为1的格子，有一个就减去1条边。比如，该格子上面有个值为1的格子，就减去1，右边有个值为1的格子，再减去1，依次检查该格子的四周。
 */
public class IslandPerimeter1 {

    /**
     * 普通的双层for循环解决
     * 注意边界
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int rowMax = grid.length;
        int colMax = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int grid0 = grid[i][j];
                if(grid0 == 1){
                    ans = ans + 4;
                    if(i>=1 && grid[i-1][j] == 1){
                        ans = ans -1;
                    }
                    if(i+1 < rowMax && grid[i+1][j] == 1){
                        ans = ans -1;
                    }
                    if(j>=1 && grid[i][j-1] == 1){
                        ans = ans -1;
                    }
                    if(j+1 <colMax && grid[i][j+1] == 1){
                        ans = ans -1;
                    }
                }
            }
        }
        return ans;
    }
}
