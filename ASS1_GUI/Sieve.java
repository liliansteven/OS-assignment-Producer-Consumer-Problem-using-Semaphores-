public class Sieve {
    private boolean prime[];
    Sieve(int N){
        prime = new boolean[N+1];
        for(int i=0;i<=N;i++)
            prime[i] = true;
        for(int p = 2; p*p <=N; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= N; i += p)
                    prime[i] = false;
            }
        }
    }
    public boolean isPrime(int x){
        return prime[x];
    }

}
