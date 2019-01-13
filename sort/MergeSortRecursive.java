package Offer.sort;

public class MergeSortRecursive {

    private static void merge(int[] arr, int left, int right, int mid){
        int i = left, j = mid + 1, k = 0;
        int[] tmpArr = new int[right - left + 1];
        while (i <= mid && j <= right) tmpArr[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
        while (i <= mid) tmpArr[k++] = arr[i++];
        while (j <= right) tmpArr[k++] = arr[j++];
        k = 0;
        while (left <= right) arr[left++] = tmpArr[k++];
    }

    public static void sort(int[] arr, int left, int right){
        if (left < right){
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, right, mid);
        }
    }


    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 8, 9, 6, 0, 7, 2, 5, 4, 4};
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
