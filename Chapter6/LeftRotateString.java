package Offer.Chapter6;

public class LeftRotateString {
    private static void reverse(char[] arr, int left, int right){
        while (left < right){
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public static String leftRotateString(String str, int n){
        if (str == null || n < 0 || n > str.length()) return "";
        char[] arr = str.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }

    public static void main(String[] args){
        System.out.println(leftRotateString("ABCDE", 0));
        System.out.println(leftRotateString("ABCDE", 3));
        System.out.println(leftRotateString("ABCDE", 5));
    }
}
