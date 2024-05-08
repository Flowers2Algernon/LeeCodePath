package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution506 {
    public static void main(String[] args) {
        Solution506 solution506 = new Solution506();
        String[] relativeRanks = solution506.findRelativeRanks1(new int[]{10,3,8,9,4});
        System.out.println(Arrays.deepToString(relativeRanks));
    }
    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        int[] sortedScore = score.clone();
        Arrays.sort(sortedScore);
        String[] ranks = new String[n];

        for (int i = 0; i < n; i++) {
            int rank = Arrays.binarySearch(sortedScore, score[i]);
            if (rank == n-1){
                ranks[i] = "Gold Medal";
            }else if (rank == n-2){
                ranks[i] ="Silver Medal";
            }else if (rank==n-3 ){
                ranks[i]="Bronze Medal";
            }else{
                ranks[i]=String.valueOf(n-rank);
            }
        }
        return ranks;
    }


    //force solution
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //the first put value, the second put location
        //store all the value and its location
        for (int i =0;i<n;i++){
            map.put(score[i],i);
        }
        String[] results = new String[n];
        int max = -1;
        int location = -1;
        int count = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        while (count<n){
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getKey()>max){
                    max = entry.getKey();
                    location = entry.getValue();
                }
            }
            if (count==0){
                results[location] = "Gold Medal";
            }else if (count == 1){
                results[location] = "Silver Medal";
            } else if (count==2) {
                results[location] = "Bronze Medal";
            }else {
                results[location] = String.valueOf(count+1);
            }
            count++;
            map.remove(max);
            max = -1;
        }
        return results;
    }
}
