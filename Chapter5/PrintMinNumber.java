package Offer.Chapter5;

import java.util.ArrayList;

public class PrintMinNumber {
    public static String printMinNumber(int[] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int anArr : arr) arrayList.add(anArr);
        arrayList.sort((o1, o2) -> {
            String ab = o1.toString() + o2.toString();
            String ba = o2.toString() + o1.toString();
            return ab.compareTo(ba);
        });
        StringBuilder sb = new StringBuilder();
        for (int e: arrayList) sb.append(e);
        return sb.toString();
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,32,321};
        System.out.println(printMinNumber(arr));
    }
}

/*
public class PrintMinNumber {
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean compare(String a, String b){
        String ab = a + b, ba = b + a;
        return ab.compareTo(ba) < 0;
    }

    private static int partition(int[] arr, int left, int right){
        int j = left - 1;
        for(int i = left; i < right; i++)
            if(compare(String.valueOf(arr[i]), String.valueOf(arr[right]))) swap(arr, i, ++j);
        swap(arr, right, ++j);
        return j;
    }

    private static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    public static String printMinNumber(int[] arr){
        quickSort(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int e: arr) sb.append(e);
        return sb.toString();
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,32,321};
        System.out.println(printMinNumber(arr));
    }

}
*/