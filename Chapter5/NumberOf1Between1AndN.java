package Offer.Chapter5;

public class NumberOf1Between1AndN {
    public static int countNumberOfOne(int n){
        if (n < 1) return 0;
        int counter = 0, base = 1, round = n;
        while (round > 0){
            int weight = round % 10;
            round /= 10;
            counter += round * base;
            if (weight == 1) counter += (n % base + 1);
            else if (weight > 1) counter += base;
            base *= 10;
        }
        return counter;
    }

    public static void main(String[] args){
        System.out.println(countNumberOfOne(10));
    }
}
