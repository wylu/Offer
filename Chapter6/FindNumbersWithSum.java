package Offer.Chapter6;

import java.util.ArrayList;
import java.util.Arrays;

public class FindNumbersWithSum {
    private static boolean findNumbers(int[] arr, int[] num1, int[] num2, int sum) {
        if (arr == null || arr.length < 1 || num1 == null || num2 == null) return false;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long curSum = arr[left] + arr[right];
            if (curSum == sum) {
                num1[0] = arr[left];
                num2[0] = arr[right];
                return true;
            } else if (curSum > sum) right--;
            else left++;
        }
        return false;
    }

    public static ArrayList<Integer> findNumbersWithSum(int[] arr, int sum) {
        ArrayList<Integer> numsList = new ArrayList<>(2);
        int[] num1 = new int[1], num2 = new int[1];
        if (findNumbers(arr, num1, num2, sum)) {
            numsList.add(num1[0]);
            numsList.add(num2[0]);
        }
        return numsList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(findNumbersWithSum(arr, 15).toArray()));
    }
}
