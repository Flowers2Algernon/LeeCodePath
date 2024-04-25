package medium;

import java.util.*;

/*You have a lock in front of you with 4 circular wheels.
Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
Each move consists of turning one wheel one slot.
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock,
return the minimum total number of turns required to open the lock, or -1 if it is impossible.*/
public class Solution752 {
    public static void main(String[] args) {
        Solution752 solution752 = new Solution752();
        System.out.println(solution752.openLock(new String[]{"1234"}, String.valueOf(1111)));
    }

    public int openLock(String[] deadends, String target) {
        //the first thing need to do is each action need to determine whether there is a deadends equals to display
//        HashMap<String, Integer> deadEndHashMap = new HashMap<>();
//        for (int i = 0; i < deadends.length; i++) {
//            deadEndHashMap.put(deadends[i], i);
//        }
        //rather the above, use the following code can reduce a for loop
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        //we need to output the slot times, so we create a count to describe the slot times
        int count = 0;
        //here we need to start with '0000',each time just slot one wheel
        ArrayDeque<String> deque = new ArrayDeque<>();
        //find the shortest path between 0000 to target and not pass the deadens.
        HashSet<String> visited = new HashSet<>();
        deque.offer("0000");
        visited.add("0000");
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String cur = deque.poll();//here we need to determine is the deque's size greater than 0
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return count;
                }
                List<String> eachResult = findEachResult(cur);
                for (String s : eachResult) {
                    if (visited.contains(s)) continue;
                    deque.offer(s);
                    visited.add(s);
                }
            }
            count++;
        }
        return -1;
    }

    public char bottomTurn(char c) {
        return (c == '9') ? '0' : (char) (c + 1);
    }

    public char topTurn(char c) {
        return (c == '0') ? '9' : (char) (c - 1);
    }

    public List<String> findEachResult(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(s);//this line should in the loop, since each loop will change and output the other two way of strings
            stringBuilder.setCharAt(i, bottomTurn(stringBuilder.charAt(i)));
            list.add(stringBuilder.toString());
//            StringBuilder temp2 = new StringBuilder(bottomTurn(stringBuilder.charAt(i)));
            stringBuilder.setCharAt(i, topTurn(stringBuilder.charAt(i)));
            list.add(stringBuilder.toString());
        }
        return list;
    }

}
