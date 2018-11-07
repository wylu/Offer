package Offer.Chapter6;

public class OneToNSum {
    public static int sumSolution(int n){
        int sum = n;
        boolean ans = (n > 0) && ((sum += sumSolution(n-1)) > 0);
        return sum;
    }

    public static void main(String[] args){
        System.out.println(sumSolution(100));
    }
}
