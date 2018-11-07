package Offer.Chapter6;

import java.util.ArrayList;
import java.util.Arrays;

public class FindContinuousSequence {
    private static ArrayList<Integer> getSequence(int small, int big){
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = small; i <= big; i++) sequence.add(i);
        return sequence;
    }

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> sequencesList = new ArrayList<>();
        if (sum < 3) return sequencesList;
        int small = 1, big = 2, mid = sum / 2;
        int curSum = small + big;
        while (small <= mid){
            if (curSum == sum){
                sequencesList.add(getSequence(small, big));
                curSum += (++big);
            } else if (curSum > sum) curSum -= (small++);
            else curSum += (++big);
        }
        return sequencesList;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> sequencesList = findContinuousSequence(9);
        for (ArrayList<Integer> e: sequencesList) {
            System.out.println(Arrays.toString(e.toArray()));
        }
    }
}
