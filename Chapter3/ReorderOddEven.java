package Offer.Chapter3;

import java.util.Arrays;

public class ReorderOddEven {
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reorderOddEven(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int p1 = 0, p2 = arr.length - 1;
        while (p1 < p2){
            while (p1 < p2 && (arr[p1] & 1) == 1) p1++;
            while (p1 < p2 && (arr[p2] & 1) == 0) p2--;
            if (p1 < p2) swap(arr, p1, p2);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,8,2,5,6,7,9,10};
        new ReorderOddEven().reorderOddEven(arr);
        System.out.println(Arrays.toString(arr));
    }
}
