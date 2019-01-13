package Offer.Chapter2;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int p1 = 0, p2 = arr.length - 1;
        if (p1 == p2 || arr[p1] < arr[p2]) return p1;
        if (arr[p1] == arr[p2]){
            for (int i = 1; i < arr.length; i++)
                if (arr[i] < arr[p1]) p1 = i;
            return arr[p1];
        }

        while (p2 - p1 != 1){
            int mid = (p1 + p2) / 2;
            if (arr[mid] >= arr[p1]) p1 = mid;
            else p2 = mid;
        }
        return arr[p2];
    }
    public static void main(String[] args){
        int[] arr = new int[]{3,4,5,1,2};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(arr));
    }
}
