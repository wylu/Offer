package Offer.Chapter6;

import java.util.Arrays;

public class IsContinuous {
    public static boolean isContinuous(int[] arr){
        if (arr == null || arr.length != 5) return false;
        Arrays.sort(arr);
        int numOfZero = 0, numOfGap = 0;
        for (int i = 0; i < arr.length && arr[i] == 0; i++) numOfZero++;
        int small = numOfZero, big = numOfZero + 1;
        while (big < arr.length){
            if (arr[small] == arr[big]) return false;
            numOfGap += arr[big] - arr[small] - 1;
            small = big++;
        }
        return numOfZero >= numOfGap;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,0,0,3};
        System.out.println(isContinuous(arr));
    }
}
