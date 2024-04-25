package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution950 {
    public static void main(String[] args) {
        Solution950 solution950 = new Solution950();
        int[] deck = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution950.deckRevealedIncreasing(deck)));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(deck);//把初始数组排序，确保是从小到大
        int[] result = new int[deck.length];
        int count = 0;
        for (int i = 0; i < deck.length; i++) {
            deque.add(i);
        }
        while (!deque.isEmpty()) {
            Integer first = deque.pollFirst();
            result[first] = deck[count];
            count++;
            if (deque.size() > 1) {
                Integer integer = deque.pollFirst();
                deque.addLast(integer);
            }else {
                continue;
            }
        }
        return result;
    }
}