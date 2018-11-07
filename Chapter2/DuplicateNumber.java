package Offer.Chapter2;

public class DuplicateNumber {
    public static boolean duplicate(int[] arr, int[] duplication) {
        if (arr == null || arr.length < 2) return false;
        boolean[] flag = new boolean[arr.length];
        for (int e : arr){
            if (flag[e]){
                duplication[0] = e;
                return true;
            }
            flag[e] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{}, duplication = new int[1];
        System.out.println(duplicate(arr, duplication));
        System.out.println(duplication[0]);
    }
}
