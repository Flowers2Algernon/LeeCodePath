package medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 73. Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

* */
public class Solution73 {
    public static void main(String[] args) {
        Solution7301 solution7301 = new Solution7301();
        int[][] matrix = {{1,1,1}, {1,0,1},{1,1,1}};
        solution7301.setZeroes(matrix);
    }
}

class Solution7301 {
    public void setZeroes(int[][] matrix) {
        //具体思路：先遍历一遍数组，当遇到0时记录其所在的行号和列号
        //拿到所有的零以后，再用一个循环去把所有记录到的行和列置为0
//        int[] newLeft = new int[100];
//        int[] newTop = new int[100];
        int row = 0;
        ArrayList<Integer> newLeft = new ArrayList<>();
        ArrayList<Integer> newTop = new ArrayList<>();
        int colum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    newLeft.add(j) ;
                    colum++;//记录列号
                    newTop.add(i) ;
                    row++;//记录行号
                }
            }
        }
        for (int i = 0; i< newTop.size(); i++) {
            for (int j =0;j< matrix[0].length;j++){
                matrix[newTop.get(i)][j]=0;
            }
        }
        for (int i = 0; i<newLeft.size(); i++) {
            for (int j =0;j< matrix.length;j++){
                matrix[j][newLeft.get(i)]=0;
            }
        }
      System.out.println(Arrays.deepToString(matrix));
    }
}