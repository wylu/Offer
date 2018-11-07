package Offer.Chapter5;

public class MoreThanHalfNum {

    private static boolean checkMoreThanHalf(int[] arr, int result){
        int times = 0;
        for (int anArr : arr) if (anArr == result) times++;
        return times > arr.length / 2;
    }

    public static int moreThanHalfNum(int[] arr){
        if (arr == null || arr.length == 0) return 0;

        int result = arr[0];
        int times = 1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] == result) times++;
            else if ((--times) == 0){
                result = arr[i];
                times = 1;
            }
        }
        return checkMoreThanHalf(arr, result) ? result : 0;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum(arr));
    }

}
