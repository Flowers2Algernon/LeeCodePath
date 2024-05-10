package medium;

/*You are given a sorted integer array arr containing 1 and prime numbers,
 where all the integers of arr are unique. You are also given an integer k.
For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
Return the kth smallest fraction considered. Return your answer as an array of integers of size 2,
where answer[0] == arr[i] and answer[1] == arr[j].*/
public class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //根据给定的数组，数组中两个元素之间位置的差值可以确定
        //不同位置差值得出的区间范围不同
        //观察k的范围，看是在哪一个范围之内，但是此方法因为不同区间范围之间的大小无法固定排序而失效
        int n = arr.length;
        double left = 0,right = 1,mid;
        int[] res = new int[2];

        while(left<=right){
            mid = left +(right-left)/2;
            int j = 1,den=0,num=0,total=0;
            double maxFrac = 0;
            for (int i = 0; i < n; ++i) {
                while (j<n&&arr[i]>=arr[j]*mid){
                    ++j;
                }
                total += n -j;
                if (j<n&&maxFrac<arr[i]*1.0/arr[j]){
                    maxFrac = arr[i]*1.0/arr[j];
                    num = i;
                    den =j;
                }
            }
            if (total==k){
                res[0]=arr[num];
                res[1]=arr[den];
                break;
            }
            if (total>k){
                right = mid;
            }else {
                left = mid;
            }

        }
        return res;
    }
}
