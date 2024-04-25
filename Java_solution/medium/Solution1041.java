package medium;


import org.junit.Test;

/*
* 1041. Robot Bounded In Circle
On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:
The north direction is the positive direction of the y-axis.
The south direction is the negative direction of the y-axis.
The east direction is the positive direction of the x-axis.
The west direction is the negative direction of the x-axis.
The robot can receive one of three instructions:
"G": go straight 1 unit.
"L": turn 90 degrees to the left (i.e., anti-clockwise direction).
"R": turn 90 degrees to the right (i.e., clockwise direction).
The robot performs the instructions given in order, and repeats them forever.
Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
*
*Example 1:
Input: instructions = "GGLLGG"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
"G": move one step. Position: (0, 1). Direction: South.
"G": move one step. Position: (0, 0). Direction: South.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
Based on that, we return true.
Example 2:
Input: instructions = "GG"
Output: false
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
Based on that, we return false.
Example 3:
Input: instructions = "GL"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
"G": move one step. Position: (-1, 1). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
"G": move one step. Position: (-1, 0). Direction: South.
"L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
"G": move one step. Position: (0, 0). Direction: East.
"L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
Based on that, we return true.
*
* */
public class Solution1041 {
    @Test
    public void test() {
        String s = "GGLLGG";
        Solution solution = new Solution();
        System.out.println(solution.isRobotBounded(s));
    }
}
//great solution ，need to attention and learn
class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;
        int x = 0;
        int y = 0;

        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                i = (i + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }
}

//class Solution {
//    public boolean isRobotBounded(String instructions) {
//        int[] position = {0, 0};//初始位置设置为0，0，第一个数字表示x轴东西，第二个数字表示y轴南北，以x轴东侧为正，y轴北侧为正
//        int[] position1 = {0, 0};//初始位置设置为0，0，第一个数字表示x轴东西，第二个数字表示y轴南北，以x轴东侧为正，y轴北侧为正
//        int direction = 0;//初始化为北
//        int count = 1;
//        boolean describeElement = true;//表示在初始位置0,0
//        for (int i = 0; i < instructions.length()&&count<300 ; count++, i++) {
//            if(direction>360){
//                direction = direction - 360;
//            }
//            if(direction<-360){
//                direction = direction+360;
//            }
//            switch (instructions.charAt(i)) {
//                case 'L': {
//                    direction = direction - 90;
//                    if (i == instructions.length() - 1) {
//                        i = -1;
//                    }
//                    if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//                        return true;
//                    }
//                    continue;
//                }
//                case 'R': {
//                    direction = direction + 90;
//                    if (i == instructions.length() - 1) {
//                        i = -1;
//                    }
//                    if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//                        return true;
//                    }
//                    continue;
//                }
//                case 'G': {
//                    if (direction == 90 || direction % 360 == 90 || direction % 360 == -270) {//东方
//                        position[0]++;
//                        if (i == instructions.length() - 1) {
//                            i = -1;
//                        }
//                        if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//                            return true;
//                        }
//                        continue;
//                    }
//                    if (direction == -90 || direction == 270 || direction % 360 == 270) {//西方
//                        position[0]--;
//                        if (i == instructions.length() - 1) {
//                            i = -1;
//                        }
//                        if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//                            return true;
//                        }
//                        continue;
//                    }
//                    if (direction == 0 || direction % 360 == 0) {//北方
//                        position[1]++;
//                        if (i == instructions.length() - 1) {
//                            i = -1;
//                        }
//                        if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//                            return true;
//                        }
//                        continue;
//                    }
//                    if (direction == 180 || direction % 360 == 180 || direction % 360 == -180) {//南方
//                        position[1]--;
//                        if (i == instructions.length() - 1) {
//                            i = -1;
//                        }
//                        if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//                            return true;
//                        }
//                        continue;
//                    }
//
//                }
//
//            }
//
//        }
//
//        if (Arrays.equals(position, position1)&&count%instructions.length()==0) {
//            return true;
//        } else return false;
//    }
//}