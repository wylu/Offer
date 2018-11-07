package Offer.Chapter6;

public class FindNumsAppearOnce {
    private static int findFirstBitIsOne(int num) {
        int counter = 0;
        while ((num >>>= 1) != 0) counter++;
        return counter;
    }

    private static boolean isBitOne(int num, int indexBit) {
        return (num >>> indexBit & 1) == 1;
    }

    public static void findNumsAppearOnce(int[] arr, int[] num1, int[] num2) {
        if (arr == null || arr.length < 2) return;
        int resExclusiveOr = 0;
        for (int e : arr) resExclusiveOr ^= e;
        int indexBit = findFirstBitIsOne(resExclusiveOr);
        num1[0] = 0;
        num2[0] = 0;
        for (int e : arr) {
            if (isBitOne(e, indexBit)) num1[0] ^= e;
            else num2[0] ^= e;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1], num2 = new int[1];
        findNumsAppearOnce(arr, num1, num2);
        System.out.println("num1=" + num1[0] + " num2=" + num2[0]);
    }
}
