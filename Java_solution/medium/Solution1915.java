package medium;

public class Solution1915 {
    public static void main(String[] args) {
        Solution1915 solution1915 = new Solution1915();
        System.out.println(solution1915.wonderfulSubstrings("he"));
    }
    //a wonderful substring is a string where at most one letter appears an odd number ot times
    //return the number of wonderful non-null substrings in word
    //this method is good, but the time is exceeded the limit, need to opt
    public long wonderfulSubstrings(String word) {
        int[] dp = new int['j'-'a'+1];
        int result  = 0;
        for (int i =0;i<word.length();i++){
            for (int j =i+1;j<=word.length();j++){
                dp =new int['j'-'a'+1];
                int oddCount = 0;//each time reset the dp
                String newString =word.substring(i,j);
                char[] charArray = newString.toCharArray();
                for (char c : charArray) {
                    dp[c-'a']++;
                }
                for (int i1 : dp) {
                    if (i1%2==0){
                        continue;
                    }else {
                        oddCount++;
                    }
                }
                if (oddCount<=1){
                    result++;
                }
            }
        }
        return result;
    }

    public long wonderfulSubstrings1(String word) {
        //use prefix to solve
        //a ^ a ==0
        //a^b==1
        //use prefix and XOR to combine solve this problem
        long[] count = new long[1024];//store the xor values
        long result = 0;
        int prefixXor = 0;
        count[prefixXor] = 1;

        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            prefixXor ^= 1 << charIndex;
            result += count[prefixXor];
            for (int i =0;i<10;i++){
                result += count[prefixXor ^ (1<<i)];
            }
            count[prefixXor]++;
        }
        return result;
    }
}
