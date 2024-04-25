package medium;

import java.util.ArrayList;
import java.util.Arrays;

/*You are given a 0-indexed m x n binary matrix land
where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.
To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland.
These rectangular areas are called groups. No two groups are adjacent,
meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.
land can be represented by a coordinate system where the top left corner of land is (0, 0)
and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left
and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1)
and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
Return a 2D array containing the 4-length arrays described above for each group of farmland in land.
If there are no groups of farmland, return an empty array. You may return the answer in any order.*/
public class Solution1992 {

    public static void main(String[] args) {
        int[][] land = {{1,0,0,1,0,1,1,0,0,1,0,1,1}};
        Solution1992 solution1992 = new Solution1992();
        System.out.println(Arrays.deepToString(solution1992.findFarmland(land)));
    }

    //find the top left element and bottom right conner element in each land, return a list
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<Integer[]> integers = new ArrayList<>();
        Integer[][] temp = new Integer[land[0].length*land.length][4];
        int count=0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1&&!visited [i][j]) {
                    temp[count][0] = i;
                    temp[count][1] = j;
                    temp[count][2] = i;
                    temp[count][3] = j;
                    integers.add(findEachLandCornerElements(land,i,j,visited,temp[count]));
                    count++;
                    // System.out.println(Arrays.deepToString(integers.toArray()));
                }
            }
        }
//        int[][] ans = new int[integers.size()][4];
//        for (int i = 0; i < integers.size(); i++) {
//            ans[i][0]=integers.get(i)[0];
//            ans[i][1]=integers.get(i)[1];
//            ans[i][2]=integers.get(i)[2];
//            ans[i][3]=integers.get(i)[3];
//        }
        //for loop is fast than stream
        int[][] array1 = integers.stream().map(array -> Arrays.stream(array).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
//        int[][] integers1 = (int[][]) integers;
        return array1;
    }
    public Integer[] findEachLandCornerElements(int[][] land,int i,int j,boolean[][] visited,Integer[] integersArray) {
        if (i<0||j<0||i>=land.length||j>=land[0].length||land[i][j]!=1 || visited [i][j]){
            return null;
        }
        //i，j presents current coordinate, how to compare ?
        visited[i][j]=true;
        //in the dfs recursion progress, we need to compare each element's coordinate
        //following need to do is implement the compare logic
        if (i<=integersArray[0]&&j<=integersArray[1]){
            integersArray[0]=i;
            integersArray[1]=j;
        }
        if (i>=integersArray[2]&&j>=integersArray[3]){
            integersArray[2]=i;
            integersArray[3]=j;
        }
        //the recursion results dont combined in one solution

        findEachLandCornerElements(land,i-1,j,visited,integersArray);
        findEachLandCornerElements(land,i+1,j,visited,integersArray);
        findEachLandCornerElements(land,i,j-1,visited,integersArray);
        findEachLandCornerElements(land,i,j+1,visited,integersArray);
        return integersArray;
    }
}
