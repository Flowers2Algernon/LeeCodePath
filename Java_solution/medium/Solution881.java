package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
 Each boat carries at most two people at the same time,
 provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.*/
public class Solution881 {
    public static void main(String[] args) {
        System.out.println(new Solution881().numRescueBoats(new int[]{3,2,2,1}, 3));
    }
    //given a number of people
    //each boat can only carrying limit number people
    //return the minimum number of boats
    //two pointer method
    public int numRescueBoats(int[] people, int limit) {
        if (people == null){
            return 0;
        }
        ArrayList<Integer> collect = IntStream.of(people).boxed().sorted().collect(Collectors.toCollection(ArrayList::new));
        long greaterThanLimit = collect.stream().filter(x -> x >= limit).count();
//        System.out.println(greaterThanLimit+" greaterThanLimit");
        int count =(int) greaterThanLimit;
        int minPointer = 0;
        int maxPointer = collect.size()-count-1;
        while (true){
            if (maxPointer<minPointer){
                return count;
            }
            if (maxPointer==minPointer){
                return count+1;
            }
            if (maxPointer>minPointer){
                //here we do dual pointer move
                if (collect.get(maxPointer)+collect.get(minPointer)>limit){
                    //cant combine to carry
                    count++;
                    maxPointer--;
                }else {
                    count++;
                    minPointer++;
                    maxPointer--;
                }
            }
        }
//        return count;
    }

    //greedy method
    public int numRescueBoats1(int[] people, int limit) {
        int boats = 0;
        int i =0;
        int j =people.length-1;
        Arrays.sort(people);
        while (i<=j){
            if (people[i]+people[j]<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
