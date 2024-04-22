package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
*  represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
*  You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order
* by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
*
* Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*{{1,2},{3,5},{6,7},{8,10},{12,16}};
* */
public class Solution57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};
        Solution5703 solution5701 = new Solution5703();
        System.out.println(Arrays.deepToString(solution5701.insert(intervals, newInterval)));
    }
}



class Solution5703{
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i =0;//count
        List<int[]> result = new ArrayList<>();
        while (i<intervals.length){
            if (intervals[i][1]<newInterval[0]){
                result.add(intervals[i]);//just add
            } else if (intervals[i][0]>newInterval[1]) {
                break;//if there is a merge, we should add the interval last
            }else {//merge
                newInterval[0] =  Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] =  Math.max(intervals[i][1],newInterval[1]);

            }
            i++;
        }
        result.add(newInterval);
        while (i<intervals.length){
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()-1][2]);
    }
}








//class Solution5702 {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals == null || intervals.length == 0) {
//            int[][] defaultArrays = new int[1][2];
//            defaultArrays[0][0] = newInterval[0];
//            defaultArrays[0][1] = newInterval[1];
//            return defaultArrays;
//        }
//        int firstNewElement = newInterval[0];
//        int secondNewElement = newInterval[1];
//        int count = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (firstNewElement <= intervals[i][0] && intervals[i][0] <= secondNewElement) {
//                intervals[i][0] = 0;
//                count++;
//            }
//            if (firstNewElement <= intervals[i][1] && intervals[i][1] <= secondNewElement) {
//                intervals[i][1] = 0;
//                count++;
//            }
//        }int[][] outcomeArrays = new int[intervals.length + 1][2];
//        if (count == 0) {
//            int index = 0;
////            int[][] outcomeArrays = new int[intervals.length + 1][2];
//            for (int i = 0;index<intervals.length+1&&i <intervals.length; i++) {
//                if (i<intervals.length&&intervals[i][1] < firstNewElement) {
//                    outcomeArrays[index][0] = intervals[i][0];
//                    outcomeArrays[index][1] = intervals[i][1];
//                    index++;
//                } else if (i<intervals.length&&intervals[i][0] > secondNewElement) {
//                    outcomeArrays[index][0] = intervals[i][0];
//                    outcomeArrays[index][1] = intervals[i][1];
//                    index++;
//                } else if (i<intervals.length&&intervals[i][0]<firstNewElement&&intervals[i][1]>secondNewElement){
//                    outcomeArrays[index][0] = intervals[i][0];
//                    outcomeArrays[index][1] = intervals[i][1];
//                    index++;
//                }else if (i<intervals.length){
//                    outcomeArrays[index][0] = firstNewElement;
//                    outcomeArrays[index][1] = secondNewElement;
//                    index++;
//                }
//            }
////            return outcomeArrays;
//        }
//
//        int index = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][0] == 0 && intervals[i][1] == 0) {
//                continue;
//            } else {
//                if (intervals[i][0] == 0) {//此时不是两个都为0，第一个数为0，意味着第二个数保持原状
//                    outcomeArrays[index][0] = 0;//此处赋值有问题--先置为0，后续再处理
//                    outcomeArrays[index][1] = intervals[i][1];
//                    index++;
//                } else if (intervals[i][1] == 0) {//此时不是两个都为0，第二个数为0，意味着第一个数保持原状
//                    outcomeArrays[index][0] = intervals[i][0];
//                    outcomeArrays[index][1] = 0;//先置为0，后续再处理
//                    index++;
//                } else {
//                    outcomeArrays[index][0] = intervals[i][0];
//                    outcomeArrays[index][1] = intervals[i][1];
//                    index++;
//                }
//            }
//        }
//        if (index == 0) {
//            intervals[0][0] = firstNewElement;
//            intervals[0][1] = secondNewElement;
//            return intervals;
//        }
//        int resultIndex = 0;
//        for (int i = 0; i < index; i++) {
//            if (outcomeArrays[i][0] != 0 && outcomeArrays[i][1] != 0) {
//                resultIndex++;
//                continue;
//            }
//            if (outcomeArrays[i][0] == 0 && outcomeArrays[i][1] == 0) {
//                continue;
//            }
//            if (outcomeArrays[i][1] == 0 && (i != index - 1 && outcomeArrays[i + 1][0] == 0)) {//此处只考虑了要合并的情况
//                outcomeArrays[i][1] = outcomeArrays[i + 1][1];
//                outcomeArrays[i + 1][1] = 0;
//                resultIndex++;
//            }
//            if (outcomeArrays[i][1] == 0 && (i != index - 1 && outcomeArrays[i + 1][0] != 0)) {
//                outcomeArrays[i][1] = secondNewElement;
//                resultIndex++;
//            }
//            if (outcomeArrays[i][1] == 0 && i == index - 1) {
//                outcomeArrays[i][1] = secondNewElement;
//                resultIndex++;
//            }
//
//        }
//        int[][] outcomeArrays1 = new int[resultIndex][2];
//        resultIndex = 0;
//        int unZeroCount = 0;
//        for (int i = 0; i < outcomeArrays.length; i++) {
//            if (outcomeArrays[i][0] != 0 && outcomeArrays[i][1] != 0) {
//                unZeroCount++;
//                outcomeArrays1[resultIndex][0] = outcomeArrays[i][0];
//                outcomeArrays1[resultIndex][1] = outcomeArrays[i][1];
//                if (resultIndex == 1 && index == 1) {
//                    return outcomeArrays1;
//                }
//                resultIndex++;
//            }
//        }
//        int[][] outcomeArrays2 = new int[unZeroCount][2];
//        unZeroCount = 0;
//        for (int i = 0; i < outcomeArrays1.length; i++) {
//            if (outcomeArrays1[i][0] != 0 && outcomeArrays1[i][1] != 0) {
//                outcomeArrays2[unZeroCount][0] = outcomeArrays1[i][0];
//                outcomeArrays2[unZeroCount][1] = outcomeArrays1[i][1];
//                unZeroCount++;
//            }
//        }
//        return outcomeArrays2;
//    }
//}
//
//class Solution5701 {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals == null || intervals.length == 0) {
//            int[][] defaultArrays = new int[1][2];
//            defaultArrays[0][0] = newInterval[0];
//            defaultArrays[0][1] = newInterval[1];
//            return defaultArrays;
//        }
//        int newFirstElement = newInterval[0];
//        int newLastElement = newInterval[1];
//        int[][] outcomeInterval = new int[intervals.length + 1][2];
//        int outcomeArrayIndex = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (newFirstElement > intervals[i][1]) {
//                outcomeInterval[outcomeArrayIndex] = intervals[i];
//                outcomeArrayIndex++;
//            }
//            while (newFirstElement < intervals[i][0] && intervals[i][0] < newLastElement && newFirstElement < intervals[i][1] && intervals[i][1] < newLastElement && i < intervals.length) {
//                i++;
//            }
//            if (newFirstElement > intervals[i][0] && newFirstElement < intervals[i][1] && i < intervals.length - 1) {
//                outcomeInterval[outcomeArrayIndex][0] = intervals[i][0];
//                if (newLastElement < intervals[i + 1][0]) {
//                    outcomeInterval[outcomeArrayIndex][1] = newLastElement;
//                }
//                if (outcomeInterval[outcomeArrayIndex][0] != 0 && outcomeInterval[outcomeArrayIndex][1] != 0) {
//                    outcomeArrayIndex++;
//                }
//            }
//            if (newLastElement >= intervals[i][0] && newLastElement < intervals[i][1]) {
//                outcomeInterval[outcomeArrayIndex][1] = intervals[i][1];
//                if (outcomeInterval[outcomeArrayIndex][0] != 0 && outcomeInterval[outcomeArrayIndex][1] != 0) {
//                    outcomeArrayIndex++;
//                }
//            }
//            if (newFirstElement > intervals[i][0] && newLastElement < intervals[i][1]) {
//                outcomeInterval[outcomeArrayIndex][0] = intervals[i][0];
//                outcomeInterval[outcomeArrayIndex][1] = intervals[i][1];
//                outcomeArrayIndex++;
//            }
//
//            if (newLastElement < intervals[i][0]) {
//                outcomeInterval[outcomeArrayIndex] = intervals[i];
//                outcomeArrayIndex++;
//            }
//        }
//        int[][] realOutcomeInterval = new int[outcomeArrayIndex][2];
//        for (int i = 0; i < outcomeArrayIndex; i++) {
//            realOutcomeInterval[i] = outcomeInterval[i];
//        }
//        return realOutcomeInterval;
//    }
//}










