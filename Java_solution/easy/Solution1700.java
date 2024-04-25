package easy;

import java.util.ArrayList;
import java.util.Objects;

/*https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/?envType=daily-question&envId=2024-04-08*/
public class Solution1700 {
    public static void main(String[] args) {
        Solution1700 solution1700 = new Solution1700();
        int[] students = new int[]{1, 0, 1, 1, 0};
        int[] sandwiches = new int[]{0, 0, 1, 1, 0};
        System.out.println(solution1700.countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        ArrayList<Integer> studentList = new ArrayList<Integer>();
        ArrayList<Integer> sandwichList = new ArrayList<>();
        for (int i =0;i<students.length;i++){
            sandwichList.add(sandwiches[i]);
            studentList.add(students[i]);
        }
        int count = 0;
        int loopCount = 0;
        while (true) {
            if (Objects.equals(sandwichList.get(count), studentList.get(count))) {
                sandwichList.remove(count);
                studentList.remove(count);
                loopCount = 0;
            } else {
                Integer remove = studentList.remove(count);
                studentList.add(remove);
                loopCount++;
            }
            if (sandwichList.isEmpty()) {
                return 0;
            }
            if (loopCount>studentList.size()){
                return studentList.size();
            }
        }
    }
}
