package week5.task;

import java.util.Arrays;

/**
 * leetcode:130. 被围绕的区域
 */
public class NO_130_SurroundedRegions {

    public static void main(String[] args) {
        NO_130_SurroundedRegions surroundedRegions = new NO_130_SurroundedRegions();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
        surroundedRegions.solve(board);
        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    /**
     * 思路：岛屿模板思路，稍作修改
     * @param board
     */
    public void solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                //从边缘的O开始深度遍历，将这种连接边缘的O全部转化为Q
                boolean isEdge = r == 0 || c == 0 || r == board.length - 1 || c == board[0].length - 1;
                if (isEdge && board[r][c] == 'O') {
                    dfs(board, r, c);
                }
            }
        }
        //再次遍历，将Q变回O，还存在的O变成X
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'Q') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    /**
     * 岛屿的遍历模板，稍作修改：将边缘相连接的O全部转为Q
     * @param board 看板
     * @param r 行
     * @param c 列
     */
    private void dfs(char[][] board,int r,int c){
        //坐标（r,c）出界了
        if(!isInArea(board,r,c)){
            return;
        }
        //X值坐标结束
        if(board[r][c] == 'X'){
            return;
        }
        //Q是已经搜索过的了
        if(board[r][c] == 'Q'){
            return;
        }
        //将边缘连接的O全部换成Q
        board[r][c] = 'Q';
        //继续向坐标（r,c）的四周:上下左右遍历
        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
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
