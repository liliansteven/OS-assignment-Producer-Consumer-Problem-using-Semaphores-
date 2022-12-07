public class Semaphore {
    protected int value;
    protected Semaphore(int val){
        this.value = val;
        }
    public synchronized void semWait() throws InterruptedException {
        if (value == 0) wait();
        value--; 
    }
    public synchronized void semSignal(int s) {
        value++;
        if (value == s) notify();
        
        }
    public boolean posValue(){
        return value > 0;
    }
}
