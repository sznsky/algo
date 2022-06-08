package brushexercises.day11;

/**
 * @Describe : 二维数组求和 leetcode:304
 * @Author : sunzhenning
 * @Since : 2022/6/8 11:11
 */
public class NumMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int sum = numMatrix.sumRegion(2,1,4,3);
        System.out.println(sum);
    }

    /**
     * 二维数组前缀和
     */
    public int[][] preSums;

    public NumMatrix(int[][] matrix) {
        if(matrix.length >0){
            //前置二维数组row和col加1的原因，防止下面的i-1或者j-1超出边界
            preSums = new int[matrix.length+1][matrix[0].length+1];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    preSums[i+1][j+1] = preSums[i+1][j] + preSums[i][j+1] - preSums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //原推导方法为：preSums[row2][col2] - preSums[row2][col1-1] - preSums[row1-1][col2] + preSums[row1-1][col1-1];
        //下面的下标都是1的情况下，因为preSums这个二维数组的row和col都扩大了一个1
        return preSums[row2+1][col2+1] - preSums[row2+1][col1] - preSums[row1][col2+1] + preSums[row1][col1];
    }
}
