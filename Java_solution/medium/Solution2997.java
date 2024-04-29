package medium;

public class Solution2997 {
    public static void main(String[] args) {
        int binaryString = Integer.parseInt(Integer.toBinaryString(3));
        int binaryString1 = Integer.parseInt(Integer.toBinaryString(2));
        int con = 0;
        con = binaryString ^ binaryString1;
        System.out.println(con);
        //above is the prepared knowledge for Java XOR


    }
    public int minOperations(int[] nums, int k) {
        int original = 0;
        //XOR all the integers in nums
        for (int num : nums) {
            original = original ^ num;
        }

        int count = 0;
        while (k>0||original>0){
            if ((k%2)!=(original%2)){
                count++;
            }
            k /=2;
            original /=2;
        }
        return count;
    }
}
