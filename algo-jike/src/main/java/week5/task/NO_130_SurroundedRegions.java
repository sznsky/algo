package week5.task;

/**
 * leetcode:130. 被围绕的区域
 */
public class NO_130_SurroundedRegions {

    /**
     * 思路：岛屿模板思路，稍作修改
     * @param board
     */
    public void solve(char[][] board) {

    }

    /**
     * 岛屿的遍历模板，修改
     * @param board 看板
     * @param r 行
     * @param c 列
     */
    private void dfs(char[][] board,int r,int c){

    }

    /**
     * 该节点（r,c）是否在看板内
     * @param board 看板
     * @param r 行
     * @param c 列
     * @return
     */
    private boolean isInArea(char[][] board,int r,int c){
        boolean rBoolean = r>=0 && r<board.length;
        boolean cBoolean = c>=0 && c<board[0].length;
        return rBoolean && cBoolean;
    }
}
