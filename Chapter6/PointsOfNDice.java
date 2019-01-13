package Offer.Chapter6;

/**
 * @author wylu
 */
public class PointsOfNDice {
    private void printProbability(int num) {
        if (num < 1) return;

        //骰子最大面值
        int diceMaxVal = 6;
        //count[][n]: 点数和为n出现的次数
        int[][] count = new int[2][diceMaxVal * num + 1];

        int flag = 0;
        for (int i = 1; i <= diceMaxVal; i++) count[flag][i] = 1;

        for (int k = 2; k <= num; k++) {
            //有k个骰子时，最小点数和为k，不存在出现点数和小于k的情况
            for (int i = 0; i < k; i++) count[1 - flag][i] = 0;

            for (int i = k; i <= diceMaxVal * k; i++) {
                count[1 - flag][i] = 0;
                for (int j = 1; j < i && j <= diceMaxVal; j++) {
                    count[1 - flag][i] += count[flag][i - j];
                }
            }

            //在下一轮中，交换两个数组，通过改变flag实现
            flag = 1 - flag;
        }

        double total = Math.pow(diceMaxVal, num);
        for (int i = num; i <= diceMaxVal * num; i++) {
            System.out.println(String.format("%d : %.6f", i, count[flag][i] / total));
        }
    }

    public static void main(String[] args) {
        new PointsOfNDice().printProbability(3);
    }
}
