package easy;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] results = new int[grid.length - 2][grid.length - 2];
        for (int i =0;i< results.length;i++){
            for (int j =0;j< results.length;j++){
                results[i][j]= findTheMaxValue1(i,j,grid);
            }
        }
        return results;
    }

    private int findTheMaxValue1(int i, int j, int[][] grid) {
        int max = 0;
        for (int k=i;k<=i+2;k++){
            for (int m=j;m<=j+2;m++){
                max = Math.max(max,grid[i][j]);
            }
        }
        return max;
    }
    private int findTheMaxValue(int i, int j, int[][] grid) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int k=i;k<=i+2;k++){
            for (int m=j;m<=j+2;m++){
                integers.add(grid[k][m]);
            }
        }
        Integer i1 = integers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).get();
        return i1;
    }
}
