package Offer.string;

public class BruteForceMatch {
    public static int search(char[] s, char[] p){
        int i = 0, j = 0;
        while (i < s.length && j < p.length){
            if (s[i] == p[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        return (j == p.length) ? i - j : -1;
    }

    public static void main(String[] args){
        char[] s = "BBC ABCDAB ABCDABCDABDE".toCharArray();
        char[] p = "ABCDABD".toCharArray();
        System.out.println(search(s, p));
    }
}
