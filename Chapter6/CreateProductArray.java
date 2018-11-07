package Offer.Chapter6;

import java.util.Arrays;

public class CreateProductArray {
    public static int[] multiply(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[arr.length];
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }
        int tmp = 1;
        for (int i = arr.length - 2; i >= 0; i--){
            tmp *= arr[i+1];
            res[i] *= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(arr)));
    }
}

/*
public class CreateProductArray {
    public static int[] multiply(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[arr.length];
        int[] prefix = new int[arr.length], suffix = new int[arr.length];
        for (int i = 1; i < arr.length; i++){
            prefix[i] = 1;
            suffix[i] = 1;
        }
        prefix[0] = arr[0];
        suffix[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1, j = arr.length - 2; i < arr.length - 1; i++, j--){
            prefix[i] = prefix[i-1] * arr[i];
            suffix[j] = suffix[j+1] * arr[j];
        }
        res[0] = suffix[1];
        for (int i = 1; i < arr.length - 1; i++)
            res[i] = prefix[i-1] * suffix[i+1];
        res[arr.length - 1] = prefix[arr.length - 2];
        return res;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(arr)));
    }
}
*/
