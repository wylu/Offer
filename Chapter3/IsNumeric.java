package Offer.Chapter3;

public class IsNumeric {
    private static boolean scanUnsignedInteger(char[] str, int[] idx){
        int startIdx = idx[0];
        while (idx[0] < str.length && str[idx[0]] >= '0' && str[idx[0]] <= '9') idx[0]++;
        return idx[0] > startIdx;
    }

    private static boolean scanInteger(char[] str, int[] idx){
        if (idx[0] < str.length && (str[idx[0]] == '+' || str[idx[0]] == '-')) idx[0]++;
        return scanUnsignedInteger(str, idx);
    }

    public static boolean isNumeric(char[] str){
        if (str == null || str.length == 0) return false;
        int[] idx = new int[]{0};
        boolean numeric = scanInteger(str, idx);
        if (idx[0] != str.length && str[idx[0]] == '.'){
            idx[0]++;
            numeric = scanUnsignedInteger(str, idx) || numeric;
        }
        if (idx[0] != str.length && (str[idx[0]] == 'e' || str[idx[0]] == 'E')){
            idx[0]++;
            numeric = numeric && scanInteger(str, idx);
        }
        return numeric && idx[0] == str.length;
    }

    public static void main(String[] args){
        System.out.println(isNumeric(".123".toCharArray()));
        System.out.println(isNumeric("123.".toCharArray()));
        System.out.println(isNumeric(".e2".toCharArray()));
        System.out.println(isNumeric("12e".toCharArray()));
    }
}
