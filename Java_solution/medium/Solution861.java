package medium;

public class Solution861 {
    public static void main(String[] args) {
        Solution861 solution861 = new Solution861();
         int[][]  grid= {{0,1},{1,1}};
        System.out.println(solution861.matrixScore(grid));
    }
    public int matrixScore(int[][] grid) {
        int resultSum = 0;
        for (int i =0;i<grid.length;i++){
            //此处对每一行首位不是0的进行反转
            if (grid[i][0]!=1){
                //反转
                for (int j =0;j<grid[0].length;j++){
                   if (grid[i][j]==0){
                       grid[i][j]=1;
                   }else {
                       grid[i][j]=0;
                   }
                }
            }
        }
        for (int i =1;i<grid[0].length;i++){
            //此处统计每一个竖列中1的个数
            //i表示列
            int countOnePerColum = 0;
            //统计列中1的个数时grid[i][j]的位置写反
            //j的范围写错导致出现数组越界错误
            for (int j =0;j<grid.length;j++){
                if (grid[j][i]==1){
                    countOnePerColum++;
                }
            }
            if (countOnePerColum<grid.length-countOnePerColum){
                //反转
                for (int j =0;j<grid.length;j++){
                    if (grid[j][i]==0){
                        grid[j][i]=1;
                    }else {
                        grid[j][i]=0;
                    }
                }
            }
        }
        //此处对每列的数相加
        for (int i=0;i<grid.length;i++){
            for (int j = grid[0].length-1; j >=0; j--) {//此处计算有误，越是前面的数应该幂值越大，而此处是越前面的越小
                resultSum += (int) (grid[i][j]*Math.pow(2,grid[0].length-1-j));
            }
        }
        return resultSum;
    }
}
