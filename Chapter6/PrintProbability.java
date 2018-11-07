package Offer.Chapter6;

import java.util.Arrays;

public class PrintProbability {
    public static double[] printProbability(int n){
        if (n < 1) return null;
        final int DICE = 6;
        int[][] counts = new int[2][DICE * n + 1];

        int flag = 0;
        for (int i = 1; i <= DICE; i++) counts[flag][i] = 1;

        for (int k = 2; k <= n; k++){
            for (int i = 1; i < k; i++) counts[1-flag][i] = 0;

            for (int i = k; i <= DICE * k; i++){
                counts[1-flag][i] = 0;
                for (int j = 1; j < i && j <= DICE; j++)
                    counts[1-flag][i] += counts[flag][i-j];
            }
            flag = 1 - flag;
        }

        double total = Math.pow(DICE, n);
        double[] pr = new double[DICE * n + 1];
        for (int i = n; i <= DICE * n; i++) pr[i] = counts[flag][i] / total;
        return pr;
    }

    public static void main(String[] args){
        double[] pr = printProbability(3);
        System.out.println(Arrays.toString(pr));
    }
}
