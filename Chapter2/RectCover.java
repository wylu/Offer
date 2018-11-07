package Offer.Chapter2;

public class RectCover {
    public int rectCover(int n){
        int[] f = new int[]{0, 1, 2};
        if (n < 3) return f[n];

        for (int i = 3; i <= n; i++){
            f[0] = f[1] + f[2];
            f[1] = f[2];
            f[2] = f[0];
        }
        return f[2];
    }
}
