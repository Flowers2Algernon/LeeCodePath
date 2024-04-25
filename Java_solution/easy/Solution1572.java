package easy;
/*
https://leetcode.com/problems/matrix-diagonal-sum/description/
* 1572. Matrix Diagonal Sum
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on
*  the primary diagonal and all the elements
* on the secondary diagonal that are not part of the primary diagonal.
* */

import org.junit.Test;

public class Solution1572 {
    @Test
    public void test1(){
        int[][] mat = {{1,2,3}, {4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        //先判断是几维数组，given的是一个square
        for(int i = 0;i<mat.length;i++){
            for(int j =0;j<mat[i].length;j++){
                if(j==i||j== mat.length-1-i){
                    sum = sum+mat[i][j];
                }
            }
        }
        return sum;
        }
    }
