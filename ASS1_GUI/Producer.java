public class Producer extends Thread {
    Buffer buff;
    int N;
    Sieve sieve ;
    public Producer(Buffer buff, int N) {
    this.buff = buff;
    this.N = N;
    sieve = new Sieve(N);
    }
    public void run() {
        buff.startTime = System.currentTimeMillis();
        for (int i = 1; i <= N; i++){
            if(sieve.isPrime(i)){
                try {
                    buff.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        buff.notFinished = false;
    }
}
