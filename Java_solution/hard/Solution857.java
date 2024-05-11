package hard;

import java.text.DecimalFormat;
import java.util.*;

public class Solution857 {
    public static void main(String[] args) {
        Solution857 solution857 = new Solution857();
        int k = 2;
        System.out.println(solution857.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, k));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        //use greed sort and priority queue
        int n = quality.length;
        double minCost = Double.MAX_VALUE;
        double qualityTillNow = 0;

        List<Worker> worker = new ArrayList<Worker>();
        for (int i =0;i<n;i++){
            worker.add(new Worker(wage[i]*1.0/quality[i],quality[i]));
        }
        //sorting workers by their wage-quality ratio
        Collections.sort(worker);

        //Max-heap for the qualities using a comparator
        PriorityQueue<Integer> highQualityWorkers = new PriorityQueue<>(Comparator.reverseOrder());

        for (Worker worker1 : worker) {
            double ratio  = worker1.ratio;
            int qua =worker1.quality;
            qualityTillNow += qua;
            highQualityWorkers.add(qua);

            if (highQualityWorkers.size()>k){
                qualityTillNow -= highQualityWorkers.poll();
            }
            if (highQualityWorkers.size()==k){
                minCost = Math.min(minCost,qualityTillNow*ratio);
            }
         }
        return minCost;
    }

    private class Worker implements Comparable<Worker> {
        double ratio;
        int quality;

        public Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }

        @Override
        public int compareTo(Worker other) {
            return Double.compare(this.ratio, other.ratio);
        }
    }

    //以下代码对一些情况无法得出正确的结果
    public double mincostToHireWorkers1(int[] quality, int[] wage, int k) {
        //each works pay must be directly proportional to their quality
        //return the least amount money needed to form a paid group
        ArrayList<HashMap<Integer, Double>> eachWorkerQaulityWageList = new ArrayList<>();
        //the first is quality, the second is wage
        double flag = 0;
        int location = -1;
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        ArrayList<Double> flags = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            HashMap<Integer, Double> map = new HashMap<>();
            map.put(quality[i], (double) wage[i]);
            eachWorkerQaulityWageList.add(map);
            if ((double) quality[i] / wage[i] > flag) {
                location = i;
                flag = (double) quality[i] / wage[i];
            }
            flags.add(Double.valueOf(decimalFormat.format((double) quality[i] / wage[i])));
        }
        //[{3=4.0}, {1=8.0}, {10=2.0}, {10=2.0}, {1=7.0}]
        //here we need to find the 基准点
        //low quality ask for high pay -- pass
        //we need to find the high quality and low pay people
        double sumAmount = 0;
        ArrayList<Double> clone = (ArrayList<Double>) flags.clone();
        flags.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });//此处sort有问题
//        System.out.println(flags);
//        System.out.println(clone);
        //find the greatest k value
        //in this k value, find the minimal quality and set this to basement quality
        //the problem is here we dont know how the each quality in sorted arraylist
        //here we transfer the arralist to
        int n = quality.length;
        int baseLocation = 0;
        int minimal = Integer.MAX_VALUE;
        HashMap<Integer, Integer> greatestKMan = new HashMap<>();
        HashMap<Integer, Integer> sameQualityAppearTimes = new HashMap<>();
//        double[] arr = clone.stream().mapToDouble(Double::doubleValue).toArray();
        for (int i = 0; i < k; i++) {
            //here is to find the minimal quality in the greatest k flags
            Double v = flags.get(n - i - 1);
            //find its location
//            int j = Arrays.binarySearch(arr, v);
//            int j = List.of(clone).indexOf(v);
            int j = clone.indexOf(v);
            if (quality[j] < minimal) {
                minimal = quality[j];
                baseLocation = j;
            }//此处得到的不一定是最合适的基准worker,需要对此处K范围内的worker都当作基准来计算一遍，再取出最小值
            greatestKMan.put(quality[j], wage[j]);
            if (sameQualityAppearTimes.containsKey(quality[j])) {
                sameQualityAppearTimes.put(quality[j], sameQualityAppearTimes.get(quality[j]) + 1);
            } else sameQualityAppearTimes.put(quality[j], 1);
        }
        //here we got the baseLocation
        //then we calculate each salary and accumulate it
        //but how we get the other k-1 elements wages and quality
        int baseQuality = 0;
        int baseWage = 0;
        double resultSum = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            //此处是对每一个基准工人计算其对应的所需工资总和，遍历结束后返回最小的
            boolean fine = true;
            Double v = flags.get(n - j - 1);
            int i = clone.indexOf(v);
            baseQuality = quality[i];
            baseWage = wage[i];
            Set<Map.Entry<Integer, Integer>> entries = greatestKMan.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                int times = sameQualityAppearTimes.get(entry.getKey());
                if (baseQuality != entry.getKey()) {
                    if (entry.getKey() * 1.0 * baseWage / baseQuality < entry.getValue()) {
                        fine = false;
                        break;
//                        sumAmount += entry.getValue()*times;
                    } else {
                        sumAmount += entry.getKey() * 1.0 * baseWage * times / baseQuality;
                    }
                } else sumAmount += baseWage;
            }
            if (sumAmount < resultSum && fine) {
                resultSum = sumAmount;
            }
        }

        return Double.parseDouble(decimalFormat.format(resultSum));
    }
}
