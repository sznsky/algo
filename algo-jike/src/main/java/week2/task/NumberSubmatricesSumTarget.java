package week2.task;

/**
 * @Describe : leetcode:1074 【元素和为目标值的子矩阵数量】
 * @Author : sunzhenning
 * @Since : 2022/6/9 2:46
 */
public class NumberSubmatricesSumTarget {

    public static void main(String[] args) {
        NumberSubmatricesSumTarget numberSubmatricesSumTarget = new NumberSubmatricesSumTarget();
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
        int ans = numberSubmatricesSumTarget.numSubmatrixSumTarget(matrix,target);
        System.out.println(ans);
    }

    private int[][] preSums;


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        if(matrix.length >0){
            //前置二维数组row和col加1的原因，防止下面的i-1或者j-1超出边界
            preSums = new int[matrix.length+1][matrix[0].length+1];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    preSums[i+1][j+1] = preSums[i+1][j] + preSums[i][j+1] - preSums[i][j] + matrix[i][j];
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                for(int m = 0;m<i;m++){
                    for(int n=0;n<j;n++){
                        ans = Math.max(ans,sumRegion(i,j,m,n));
                    }
                }
            }
        }
        return ans;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //原推导方法为：preSums[row2][col2] - preSums[row2][col1-1] - preSums[row1-1][col2] + preSums[row1-1][col1-1];
        //下面的下标都是1的情况下，因为preSums这个二维数组的row和col都扩大了一个1
        return preSums[row2+1][col2+1] - preSums[row2+1][col1] - preSums[row1][col2+1] + preSums[row1][col1];
    }

}
