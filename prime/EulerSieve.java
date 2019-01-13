package Offer.prime;

import java.util.ArrayList;

public class EulerSieve {
    public static int[] sieve(int n){
        int[] mark = new int[n+1]; //元素值为0表示该元素下标值为素数
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i=2; i<=n; i++){
            if (mark[i] == 0) primes.add(i);
            for (int j=0; j<primes.size() && i*primes.get(j)<=n; j++){
                mark[i*primes.get(j)] = 1;
                if (i % primes.get(j) == 0)
                    break;
            }
        }
        int[] ans = new int[primes.size()];
        for (int i=0; i<primes.size(); i++)
            ans[i] = primes.get(i);
        return ans;
    }

    public static void main(String[] args){
        int[] ans = EulerSieve.sieve(100);
        for (int e: ans) {
            System.out.println(e + " ");
        }
    }
}
