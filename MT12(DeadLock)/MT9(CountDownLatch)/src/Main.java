import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService es  = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 3; i++)
            es.submit(new Processor(countDownLatch));


        es.shutdown();

        countDownLatch.await();
        System.out.println("Latch has been opened, main thread is proceeding");


    }

}


class Processor implements Runnable{
    private CountDownLatch countDownLatch;


    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
    }
}