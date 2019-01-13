package Offer.string;

public class KMP {
    public static int[] getNextArray(char[] p){
        int[] next = new int[p.length];
        int k = -1, j = 0;
        next[0] = -1;
        while (j < p.length - 1){
            if (k == -1 || p[k] == p[j]){
                k++;
                j++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static int[] getNextArray(String p){
        return KMP.getNextArray(p.toCharArray());
    }

    public static int search(char[] s, char[] p){
        int[] next = KMP.getNextArray(p);
        int i = 0, j = 0;
        while (i < s.length && j < p.length){
            if (j == -1 || s[i] == p[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return (j == p.length) ? i - j : -1;
    }

    public static int search(String s, String p){
        return KMP.search(s.toCharArray(), p.toCharArray());
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(KMP.search(s, p));
    }
}
