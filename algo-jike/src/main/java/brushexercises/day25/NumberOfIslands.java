package brushexercises.day25;

/**
 * @Describe : leetcode:200. 岛屿数量
 * @Author : sunzhenning
 * @Since : 2022/6/23 17:32
 * 思路：岛屿问题遍历模板
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands number = new NumberOfIslands();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int count = number.numIslands(grid);
        System.out.println(count);
    }


    public int numIslands(char[][] grid) {
        int count = 0;
        for(int r =0;r < grid.length;r++){
            for(int c=0;c < grid[0].length;c++){
                if(grid[r][c] == '1'){
                    int islandSquare =  area(grid,r,c);
                    if(islandSquare >= 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    int area(char[][] grid,int r,int c){
        if(!inArea(grid, r, c)){
            return 0;
        }
        if(grid[r][c] !='1'){
            return 0;
        }
        //遍历过岛屿小格子的给2
        grid[r][c] = 2;
        return 1+
                area(grid, r-1,c) +
                area(grid, r+1,c) +
                area(grid, r,c-1) +
                area(grid, r,c+1);
    }

    boolean inArea(char[][] grid,int r,int c){
        return r>=0 && r < grid.length
                && c>=0 && c < grid[0].length;
    }

}
