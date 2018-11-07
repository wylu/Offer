package Offer.sort;

public class QuickSortRecursive {

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right, base = arr[left], tmp;
        while (i < j) {
            while (arr[j] >= base && i < j) j--;
            while (arr[i] <= base && i < j) i++;
            if (i < j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        return i;
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = partition(arr, left, right);
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

    public static void main(String[] agrs) {
        int[] arr = new int[]{3, 9, 8, 1, 6, 0, 7, 2, 5, 4};
        for (int e: arr) {
            System.out.print(e + "");
        }
        System.out.println();
        sort(arr, 0, arr.length - 1);
        for (int e: arr) {
            System.out.print(e + "");
        }
        System.out.println();
    }

}
