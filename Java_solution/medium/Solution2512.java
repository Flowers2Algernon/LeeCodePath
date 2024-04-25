package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
* 2512. Reward Top K Students
You are given two string arrays positive_feedback and negative_feedback,
*  containing the words denoting positive and negative feedback, respectively.
*  Note that no word is both positive and negative.
Initially every student has 0 points.
* Each positive word in a feedback report increases the points of a student by 3,
* whereas each negative word decreases the points by 1.
You are given n feedback reports,
* represented by a 0-indexed string array report and a 0-indexed integer array student_id,
*  where student_id[i] represents the ID of the student who has received the feedback report report[i].
* The ID of each student is unique.
Given an integer k, return the top k students after ranking them in non-increasing order by their points.
* In case more than one student has the same points, the one with the lower ID ranks higher.
*
*
* */

public class Solution2512 {
}

class Solution251201 {
    class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            HashMap<String, Integer> studentScore = new HashMap<String, Integer>();
            //把分数和学号放到hashmap里面去
            //对hashmap进行排序
            //输出前k个hashmap的值
            for (int i = 0; i < positive_feedback.length; i++) {
                studentScore.put(positive_feedback[i], 3);
            }
            for (int i = 0; i < negative_feedback.length; i++) {
                studentScore.put(negative_feedback[i], -1);
            }
            int[][] finalStudentScoreAndStuId = new int[student_id.length][2];//0表示分数,1表示ID
            for (int i = 0; i < report.length; i++) {
                int count = 0;
                for (String subString : report[i].split(" ")) {
                    if(studentScore.containsKey(subString)) {
                        finalStudentScoreAndStuId[i][0] +=studentScore.get(subString);
                    }
                }
                finalStudentScoreAndStuId[i][1] = student_id[i];
                }
            //接下来是排序
            Arrays.sort(finalStudentScoreAndStuId,((a,b)->{
                if (a[0]==b[0]){//此时想按照ID升序排列
                    return Integer.compare(a[1],b[1]);
                }else return Integer.compare(b[0],a[0]);
            }));
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0;i<k;i++){
                list.add(i,finalStudentScoreAndStuId[i][1]);
            }
            return list;
            }
        }
    }


    class Solution251201UseForLoopTimeRunOut {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            int[] score = new int[student_id.length];
            for (int i = 0; i < score.length; i++) {
                score[i] = 0;
            }
            int[][] studentScore = new int[student_id.length][2];
            //要精确匹配一个字符串中是否出现了某个数组，并计算次数，要使用正则表达式
            for (int i = 0; i < report.length; i++) {//对report中每一句评价进行分析，每一句评价代表一个学生
                for (int j = 0; j < positive_feedback.length; j++) {//正向评价判断
                    Pattern pattern = Pattern.compile("\\b" + positive_feedback[j] + "\\b");
                    Matcher matcher = pattern.matcher(report[i]);
                    while (matcher.find()) {
                        score[i] = score[i] + 3;
                    }
                }
                for (int l = 0; l < negative_feedback.length; l++) {//负面评价判断
                    Pattern pattern = Pattern.compile("\\b" + negative_feedback[l] + "\\b");
                    Matcher matcher = pattern.matcher(report[i]);
                    while (matcher.find()) {
                        score[i] = score[i] - 1;
                    }

                }
            }
            for (int i = 0; i < score.length; i++) {
                studentScore[i][0] = score[i];
                studentScore[i][1] = student_id[i];
            }
//        Arrays.stream(score).sorted();
            //under the code is the sort method to studentScore,排序
            //还有一个待解决的问题：当两个学生的分数相等时，学生Id小的排前面
            int[][] newString = new int[1][1];
            for (int i = 0; i < studentScore.length; i++) {
                for (int j = 0; j < studentScore.length - 1; j++) {
                    if ((studentScore[j][0] < studentScore[j + 1][0]) || (studentScore[j][0] == studentScore[j + 1][0] && studentScore[j][1] > studentScore[j + 1][1])) {
                        newString[0] = studentScore[j + 1];
                        studentScore[j + 1] = studentScore[j];
                        studentScore[j] = newString[0];
                    }
                }
            }
            //输出前k个
            int[] newScore = new int[k];
            for (int i = 0; i < k; i++) {
                newScore[i] = studentScore[i][1];
            }
            List<Integer> list = new ArrayList<>();
            for (int i : newScore) {
                Integer integer = i;
                list.add(integer);
            }
            return list;
        }
    }













