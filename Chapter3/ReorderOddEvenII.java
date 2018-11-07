package Offer.Chapter3;

public class ReorderOddEvenII {
    public void reOrderArray(int[] arr){
        if (arr == null || arr.length < 2) return;
        int[] res = new int[arr.length];
        int k = 0;
        for (int e : arr) if ((e & 1) == 1) res[k++] = e;
        for (int e : arr) if ((e & 1) == 0) res[k++] = e;
        System.arraycopy(res, 0, arr, 0, k);
    }
}
