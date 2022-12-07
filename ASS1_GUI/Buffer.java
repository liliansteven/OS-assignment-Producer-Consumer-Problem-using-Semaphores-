public class Buffer {
    private int size;
    private int buff[];
    private int inp = 0;
    private int out = 0; 
    Semaphore empty;
    Semaphore occupied;
    long startTime=0;
    long endTime=0;
    long totalTime=0;
    public boolean notFinished = true;
    Buffer(int s){
        size = s;
        buff = new int[size];
        empty = new Semaphore(size);
        occupied = new Semaphore(0);
    }
    public void produce(int value) throws InterruptedException {
        empty.semWait();
        buff[inp] = value;
        inp = (inp + 1) % size;
        occupied.semSignal(size);
    }
    public int consume() throws InterruptedException {
        int value;
        occupied.semWait();
        value = buff[out];
        out = (out + 1) % size;
        empty.semSignal(size);
        return value;
    }
    public boolean notempty(){
        return occupied.posValue();
    }
}
