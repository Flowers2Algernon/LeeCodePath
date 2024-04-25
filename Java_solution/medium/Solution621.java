package medium;

import java.util.HashMap;

/*
* 621. Task Scheduler
You are given an array of CPU tasks, each represented by letters A to Z,
* and a cooling time, n. Each cycle or interval allows the completion of one task.
* Tasks can be completed in any order, but there's a constraint:
* identical tasks must be separated by at least n intervals due to cooling time.

Return the minimum number of intervals required to complete all tasks.
*https://leetcode.com/problems/task-scheduler/description/?envType=daily-question&envId=2024-03-19
*
*
* */
public class Solution621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n =2;
        Solution62101 solution62101 = new Solution62101();
        System.out.println(solution62101.leastInterval(tasks, n));
    }
}
class Solution62101 {
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        int coolingTime = n;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('1',1000);
        for ( char c = 'A'; c < 'Z'; c++) {
            hashMap.put(c,0);//对hashmap里面每一个值赋初始值，确保下方循环不出现空指针
        }
        for (char task : tasks) {
            hashMap.put(task, hashMap.get(task) + 1);
        }
//        while (true){
//        }
        return 1;
    }
}