package Offer.Chapter5;

public class GetUglyNumber {

    public static int getUglyNumber(int n){
        if(n < 1) return 0;
        int[] arr = new int[n];
        arr[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < n; i++){
            int m2 = arr[t2] * 2, m3 = arr[t3] * 3, m5 = arr[t5] * 5;
            arr[i] = Math.min(Math.min(m2, m3), m5);
            while (arr[t2] * 2 <= arr[i]) t2++;
            while (arr[t3] * 3 <= arr[i]) t3++;
            while (arr[t5] * 5 <= arr[i]) t5++;
        }
        return arr[n-1];
    }

    public static void main(String[] args){
        System.out.println(getUglyNumber(3));
    }

}
