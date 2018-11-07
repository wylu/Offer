package Offer.Chapter5;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str){
        int[] counters = new int[123];
        for (int i = 0; i < str.length(); i++)
            counters[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (counters[str.charAt(i)] == 1) return i;
        return -1;
    }

    public static void main(String[] args){
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }
}
