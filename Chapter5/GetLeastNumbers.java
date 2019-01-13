package Offer.Chapter5;

import java.util.ArrayList;

public class GetLeastNumbers {
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int left, int right){
        int j = left - 1;
        for (int i = left; i < right; i++) if (arr[i] <= arr[right]) swap(arr, i, ++j);
        swap(arr, ++j, right);
        return j;
    }

    private static int partition2(int[] arr, int left, int right){
        int i = left, j = right, base = arr[left];
        while(i < j){
            while(arr[j] >= base && i < j) j--;
            while(arr[i] <= base && i < j) i++;
            if(i < j) swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = base;
        return i;
    }

    public static ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0 || k <= 0 || k > input.length) return result;
        int left = 0, right = input.length - 1;
        int index = partition(input, left, right);
        while(index != k - 1){
            if (index > k -1) right = index - 1;
            else left = index + 1;
            index = partition(input, left, right);
        }
        for(int i = 0; i < k; i++) result.add(input[i]);
        return result;
    }

    public static void main(String[] args){
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = getLeastNumbers(arr, 4);
        for (int e: res) {
            System.out.print(e + " ");
        }
    }
}
