package Offer.Chapter2;

public class FrogJumpSteps {
    public int jumpFloor(int n){
        int f1 = 1, f2 = 2;
        if (n == 1) return f1;
        if (n == 2) return f2;

        for (int i = 3; i <= n; i++){
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }
}
