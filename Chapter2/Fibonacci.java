package Offer.Chapter2;

public class Fibonacci {
    public int fibonacci(int n){
        int f1 = 0, f2 = 1;
        if (n == 0) return f1;
        if (n == 1) return f2;

        for (int i = 2; i <= n; i++){
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }
}
