package easy;

public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[0][0] == coordinates[1][0]) {
            int i = 1;
            while (i<coordinates.length) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }else {
                    i++;
                }
            }
            return true;
        }
        double k = 1.0 * (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        boolean isLine = true;
        int i = 1;
        while (isLine && i < coordinates.length) {
            if (coordinates[i][1] != k * coordinates[i][0] - k * coordinates[0][0] + coordinates[0][1]) {
                isLine = false;
            } else i++;
        }
        return isLine;
    }
}
