package Offer.string;

public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        StringBuilder s = new StringBuilder(A);
        s.append(A);
        StringBuilder p = new StringBuilder(B);
        p.append(B);
        System.out.println(KMP.search(s.toString().toCharArray(), p.toString().toCharArray()));
        return false;
    }

    public static void main(String[] agrs){
        char[] s = "BBC ABCDAB ABCDABCDABDE".toCharArray();
        char[] p = "ABCDABD".toCharArray();
        System.out.println(KMP.search(s, p));
    }
}
