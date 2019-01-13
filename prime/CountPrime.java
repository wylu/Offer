package Offer.prime;
import java.util.Scanner;

public class CountPrime {
    private static boolean isPrime(int num){
        for (int i=3; i<=(int)Math.sqrt(num); i+=2)
            if (num % i == 0) return false;
        return true;
    }

    private static int[] getPrimes(int n){
        int[] primes = new int[n];
        primes[0] = 2;
        int counter = 1, i = 3;
        while (counter < n){
            if(isPrime(i)) primes[counter++] = i;
            i += 2;
        }
        return primes;
    }

    public static void main(String[] args){
        int[] primes = CountPrime.getPrimes(10000);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt()-1;
            int n = scanner.nextInt()-1;
            int counter = 0;
            for (int i=m; i<n; i++){
                if(counter%10 == 9){
                    System.out.println(primes[i]);
                    counter = 0;
                }else {
                    System.out.print(primes[i] + " ");
                    counter++;
                }
            }
            System.out.println(primes[n]);
        }
    }
}
