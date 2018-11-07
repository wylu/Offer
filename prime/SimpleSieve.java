package Offer.prime;

public class SimpleSieve {
    public static int[] sieve(int n){
        int[] mark = new int[n+1]; //元素值为0代表是素数
        int counter = 0;
        for (int i = 2; i <= n; i++){
            if (mark[i] == 0){
                counter++;
                for (int j = 2 * i; j <= n; j += i){
                    mark[j] = 1;
                }
            }
        }
        int[] primes = new int[counter];
        counter = 0;
        for (int i = 2; i <= n; i++){
            if (mark[i] == 0) primes[counter++] = i;
        }
        return primes;
    }

    public static void main(String[] args){
        int[] ans = SimpleSieve.sieve(100);
        for (int e: ans) {
            System.out.println(e + " ");
        }
    }
}
