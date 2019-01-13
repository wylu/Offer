package Offer.Chapter5;

public class InversePairsCore {

    private static int merge(int[] arr, int left, int mid, int right, int[] tmp){
        int i = mid, j = right, k = right, counter = 0;
        while (i >= left && j >= mid + 1){
            if (arr[i] > arr[j]){
                counter += (j - mid);
                tmp[k--] = arr[i--];
            }else {
                tmp[k--] = arr[j--];
            }
        }
        while (i >= left) tmp[k--] = arr[i--];
        while (j >= mid + 1) tmp[k--] = arr[j--];
        k = left;
        while (left <= right) arr[left++] = tmp[k++];
        return counter;
    }

    private static int mergeSort(int[] arr, int left, int right, int[] tmp){
        if(left < right){
            int mid = (left + right) / 2;
            int part1 = mergeSort(arr, left, mid, tmp);
            int part2 = mergeSort(arr, mid + 1, right, tmp);
            int part3 = merge(arr, left, mid, right, tmp);
            return part1 + part2 + part3;
        }
        return 0;
    }

    public static int inversePairs(int[] arr){
        return mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    public static void main(String[] args){
//        int[] arr = new int[]{7,5,6,4};
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(inversePairs(arr));
    }

}
