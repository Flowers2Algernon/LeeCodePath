package hard;

import java.util.*;

/*
* Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
A falling path with non-zero shifts is a choice of exactly one element from
* each row of grid such that no two elements chosen in adjacent rows are in the same column.*/
public class Solution1289 {
    public int minFallingPathSum1(int[][] grid) {
        //use a list of hashmap to store each rows value, the first is location, the second is value,
        //and then traverse each hashmap, pick the smallest one, and also set a list of row,
        //row by row pick values only need to ensure the last row picked location is not equal to the row location now
        int sum = 0;
        List<HashMap<Integer, Integer>> hashMaps = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < grid[0].length; j++) {
                hashMap.put(j, grid[i][j]);
            }
            hashMaps.add(hashMap);
        }
        //here we got a list of hashmap present each row's location and value
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        integers.addFirst(-1);
        for (HashMap<Integer, Integer> eachHashMap : hashMaps) {
            int nearRow = integers.pollFirst();
            if (eachHashMap.containsKey(nearRow) ) {
                eachHashMap.put(nearRow,100);
            }
            int pass = 100;
            int location = -1;
            Set<Map.Entry<Integer, Integer>> entries = eachHashMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() <= pass) {
                    pass = entry.getValue();
                    location = entry.getKey();
                }
            }
            System.out.print(pass+" , ");
            sum += pass;
            integers.addFirst(location);
        }
        return sum;
    }

    //the above method cant handle or recognise following situation:
    //[82,4,30,14,38],[-68,-52,-92,65,-85],[-49,-3,-77,8,-19]
    //when the first value picks 4, the second picks -92, the third picks -49, the sum is-137
    //but when we first picks 4, second picks -85, third picks -77, the sum is -158
    //so we just compare the row's location is not enough, we also need to compare the last row picked
    // value and location and difference to the row picked now's value and location and difference
    //to solve this, we need a list or a map to store the diff and location for the min and the second min
    //the detailed store's value is <location,min>,<location,second min>,diff
    //
    public int minFallingPathSum2(int[][] grid) {
        //use a list of hashmap to store each rows value, the first is location, the second is value,
        //and then traverse each hashmap, pick the smallest one, and also set a list of row,
        //row by row pick values only need to ensure the last row picked location is not equal to the row location now
        int sum = 0;
        List<HashMap<Integer, Integer>> hashMaps = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < grid[0].length; j++) {
                hashMap.put(j, grid[i][j]);
            }
            hashMaps.add(hashMap);
        }
        //here we got a list of hashmap present each row's location and value
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        integers.addFirst(-1);
//        HashMap<Integer, Integer> initMap = new HashMap<>();
        ArrayDeque<Integer> stroreTheMinValues = new ArrayDeque<>();
        for (HashMap<Integer, Integer> eachHashMap : hashMaps) {
            int nearRow = integers.pollFirst();
            if (eachHashMap.containsKey(nearRow) ) {
                eachHashMap.put(nearRow,100);
            }
            int pass = 100;
            int location = -1;
            Set<Map.Entry<Integer, Integer>> entries = eachHashMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() <= pass) {
                    pass = entry.getValue();
                    location = entry.getKey();
                }
            }
            System.out.print(pass+" , ");
            sum += pass;
            integers.addFirst(location);
        }
        return sum;
    }
}
