package Offer.Chapter2;

public class StrToInt {
    public static int strToInt(String str){
        if (str == null || str.length() == 0) return 0;
        char signBit = str.charAt(0);
        if (signBit != '+' && signBit != '-' && (signBit < '0' || signBit > '9')) return 0;
        int res = 0, i = 1;
        if (signBit >= '0') i = 0;
        for (; i < str.length(); i++){
            if (str.charAt(i) < '0' || str.charAt(i) > '9') return 0;
            res *= 10;
            res += (str.charAt(i) - '0');
        }
        return signBit == '-' ? -res : res;
    }

    public static void main(String[] args){
        System.out.println(strToInt("+2147483647"));
        System.out.println(strToInt("4562"));
        System.out.println(strToInt("-87904562"));
    }
}
