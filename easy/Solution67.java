package easy;

public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
      String  a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
       String  b="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(solution67.addBinary(a, b));
    }
//    public String addBinary(String a, String b) {
//        BigInteger intA = new BigInteger(a,2);
//        BigInteger intB = new BigInteger(b,2);
//        BigInteger outcome;
//        outcome = intA.add(intB);
//        String binaryString = outcome.toString(2);
//        return binaryString;
//    }
    public String addBinary(String a, String b) {
        int carry = 0;
        int aCount = a.length()-1;
        int bCount = b.length()-1;
        StringBuilder s = new StringBuilder();
        while (aCount>=0||bCount>=0||carry==1){
            if (aCount>=0){
                carry += a.charAt(aCount--) - '0';
            }
            if (bCount>=0){
                carry += b.charAt(bCount--) - '0';
            }
            s.append(carry%2);
            carry = carry/2;
        }
        return s.reverse().toString();
    }
}
