package medium;

public class Solution453 {
    public static void main(String[] args) {
        Solution453 solution453 = new Solution453();
        System.out.println(solution453.minMoves(new int[]{-100,0,100}));
    }

    public int minMoves(int[] nums) {
        //each time n-1 elements increment 1
        //equally means each time one element decrement 1 virtually
        //so the task is to find the min number and find the each number in nums diff to the min numbers
        //the first is to sum the sum
        int count = 0;
        long minNumber = Long.MAX_VALUE;
        for (int num : nums) {
            if (num<minNumber){
                minNumber = num;
            }
        }
        int n = (int) minNumber;
        for (int num : nums) {
            count = count + num- n;
        }
        return count;
        /*这个问题的关键在于理解“增加n-1个元素”和“减少1个元素”的效果在相对值上是等价的。
        因为题目的目标是使所有元素相等，所以我们关注的是元素之间的差距，而不是它们的绝对值。
        为什么说相对差值更重要？
        因为每次操作使n-1个元素增加1，相对于未被选中的那个元素，可以视为它被减少了1。
        这样，问题就转化为了通过最小的操作次数来减少数组中所有元素与某个特定值（例如最小值）之间的差距。
        如果以减小的角度去看，会出现什么错误？
        实际上，如果我们直接尝试减少元素的值，可能会违反题目的操作规则（只能增加n-1个元素）。
        但是，通过将问题视为减少相对差距，我们没有真的改变任何元素的值，而是用这种视角来理解如何通过规定的操作来达到目标状态。
        简而言之，我们不是真的在操作中减少任何元素的值，而是通过每次操作减少未被增加的那个元素与其他元素的相对差距，
        从而以一种等效的方式来达到目的。
        正确的解决方案解释：
        找到最小值：因为我们可以通过将所有其他元素增加来“减少”任何给定元素，
        所以最终所有元素都应该等于数组中的最小值（或者通过足够多的增加操作，达到一个等于或高于最小值的共同值）。
        计算总和与最小值的关系：最小移动次数等于数组中所有元素的总和减去数组长度乘以最小元素的值。
        这是因为，理想情况下，所有元素都将增加到最小值的水平，这需要的总增加量就是当前总和与所有元素都是最小值时的理想总和之间的差。
        这种方法的优势在于它直接关联到了问题的核心——最小化操作次数，而不是试图通过实际减少任何元素的值来解决问题。*/
    }

    //the following method want solve the problem use find the max and set a diff to count,
    // but cant handle the while loop determine' true or false in some cases
    //only can increment 1
    //in one move, increment n-1 elements
    public int minMoves1(int[] nums) {
        if (nums.length==1 || nums.length==0){
            return 0;
        }
        double originalSum =0;
        long maxNumber = -9999999999L;//cant set this number to 0, because the range of nums elements is -1000000000
        int n = nums.length;
        long minNumber = Long.MAX_VALUE;
        for (int num : nums) {
            originalSum += num;//get original nums sum
            if (num>maxNumber){
                maxNumber = num;//record max number in nums
            }
            if (num<minNumber){
                minNumber = num;
            }
        }
        double diff = maxNumber - minNumber;
        double count = (maxNumber * n-originalSum)/(n-1);
        while (count%1!=0 || count<diff){
            count = (maxNumber * n-originalSum)/(n-1);
            maxNumber++;
        }
        return (int) count;
    }
}
