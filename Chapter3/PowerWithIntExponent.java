package Offer.Chapter3;

public class PowerWithIntExponent {
    public double power(double base, int exp){
        double res = 1;
        boolean isNegative = false;
        if (exp < 0){
            isNegative = true;
            exp = -exp;
            if (base == 0.0) return 0.0;
        }
        while (exp != 0){
            if ((exp & 1) == 1) res *= base;
            exp >>= 1;
            base *= base;
        }
        return isNegative ? 1.0 / res : res;
    }
}
