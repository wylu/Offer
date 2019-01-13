package Offer.Chapter6;

public class ReverseSentence {
    private static void reverse(char[] arr, int left, int right){
        while (left < right){
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public static String reverseSentence(String str){
        if (str == null) return null;
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int left = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == ' '){
                reverse(arr, left, i - 1);
                left = i + 1;
            }
        }
        reverse(arr, left, arr.length - 1);
        return new String(arr);
    }

    public static void main(String[] args){
        System.out.println(reverseSentence("I am a student."));
        System.out.println(reverseSentence("Wonderful"));
    }
}
