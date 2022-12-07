import java.io.IOException;

public class Consumer extends Thread {
    Buffer buff;
    int numOfPrimes=0;
    int largestPrime=0;
    public Consumer(Buffer buff) {
    this.buff = buff;
    }
    public void run() {
    while (buff.notFinished || buff.notempty()){
        try {
            int tmp = buff.consume();
            Frame1.fileWriter.write('"'+Integer.toString(tmp)+'"'+",  ");
            numOfPrimes++;
            largestPrime = tmp;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        buff.endTime = System.currentTimeMillis();
        buff.totalTime = buff.endTime - buff.startTime;
        Frame1.update(numOfPrimes, largestPrime , buff.totalTime);
        // try {
        //     Thread.sleep(50);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
    try {
        Frame1.fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
}
