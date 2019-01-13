package Offer.Chapter5;

public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] arr){
        int curSum = arr[0];
        int maxSum = curSum;
        for(int i = 1; i < arr.length; i++){
            if(curSum <= 0) curSum = arr[i];
            else curSum += arr[i];
            if(curSum > maxSum) maxSum = curSum;
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(arr));
    }
}
