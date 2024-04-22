package medium;

/*
* 54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
https://leetcode.com/problems/spiral-matrix/description/
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*
* */

import java.util.Arrays;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {
        Solution5401 solution5401 = new Solution5401();
        int[][] arrays = {{1,2,3,4},{4,5,6,8},{9,10,11,12}};

        System.out.println(Arrays.toString(solution5401.spiralOrder(arrays)));
    }
}

class Solution5401 {
    public int[] spiralOrder(int[][] matrix) {
        //仅靠一个参数来描述上下左右四个方向比较困难，且难以对boundary situation 进行判断
        //现在设置四个参数，来分别表示东南西北
        int m = matrix.length;//表示有几行
        int n = matrix[0].length;//表示每一行有多少个元素
        int[] newArrays = new int[m*n];
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        int count = 0;//表示新数组元素
        while(count<m*n){
            //首先是从左到右进行输入
            for (int i = left;i<=right&&count<m*n;i++) {
                newArrays[count] = matrix[top][i];
                count++;
            }
            top++;
            //接下来是从上到下继续添加
            for (int j = top;j<=bottom&&count<m*n;j++){
                newArrays[count] = matrix[j][right];
                count++;
            }
            right--;
            //接下来是从右到左继续添加
            for (int i = right;i>=left&&count<m*n;i--){
                newArrays[count]= matrix[bottom][i];
                count++;
            }
            bottom--;
            //接下来是从下到上继续添加
            for (int j =bottom;j>=top&&count<m*n;j--){
                newArrays[count] = matrix[j][left];
                count++;
            }
            left++;
        }
        List<Integer> list = Arrays.stream(newArrays).boxed().toList();
        return newArrays;
    }
}