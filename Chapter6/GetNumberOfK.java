package Offer.Chapter6;

public class GetNumberOfK {

    private static int getFirstK(int[] arr, int left, int right, int k){
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == k){
                if (mid == left || arr[mid-1] != k) return mid;
                right = mid - 1;
            }else if (arr[mid] < k) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static int getLastK(int[] arr, int left, int right, int k){
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == k){
                if (mid == right || arr[mid+1] != k) return mid;
                left = mid + 1;
            }else if (arr[mid] < k) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int getNumberOfK(int[] arr, int k){
        if (arr == null) return -1;
        int firstK = getFirstK(arr, 0, arr.length - 1, k);
        int lastK = getLastK(arr, 0, arr.length - 1, k);
        if (firstK == -1) return 0;
        return lastK - firstK + 1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(arr, 3));
    }
}
