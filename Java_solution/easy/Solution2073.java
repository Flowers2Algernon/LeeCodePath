package easy;

public class Solution2073 {
    public static void main(String[] args) {
        Solution2073 solution2073 = new Solution2073();
        int[] intTickets = {2,3,2};
        System.out.println(solution2073.timeRequiredToBuy(intTickets, 2));
    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;//used to record the spend seconds
        for (int i = 0; i <= tickets.length && tickets[k]!=0; i++) {
            if (i==tickets.length){
                i = -1;
                continue;
            }
            if (tickets[i] == 0) {
                continue;
            }
            else if (tickets[i]>0){
                count++;
                tickets[i]--;
            }
            if (tickets[k]==0){
                return count;
            }

        }
        return count;
    }
}
