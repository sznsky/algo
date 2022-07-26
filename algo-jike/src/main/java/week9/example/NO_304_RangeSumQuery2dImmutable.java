package week9.example;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 二维数组前缀和思想
 */
public class NO_304_RangeSumQuery2dImmutable {

    //前缀和
    int[][] sum;
    public NO_304_RangeSumQuery2dImmutable(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        sum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //初始化前缀和
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;
        //之前存在加1的操作
        return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
    }

}
