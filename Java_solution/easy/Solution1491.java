package easy;
/*
* 1491. Average Salary Excluding the Minimum and Maximum Salary
You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary.
*  Answers within 10-5 of the actual answer will be accepted.
*
* Example 1:
Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
* */
public class Solution1491 {
}
class Solution149101 {
    public double average(int[] salary) {
        double maxSalary = salary[0];
        double minSalary = salary[0];
        double sum = 0;
        for (double i : salary){
            if (i>maxSalary){
                maxSalary = i;
            }
            if (i<minSalary){
                minSalary = i;
            }
            sum = sum + i;
        }
        sum = sum - maxSalary-minSalary;
        return sum/(salary.length-2);
    }
}
