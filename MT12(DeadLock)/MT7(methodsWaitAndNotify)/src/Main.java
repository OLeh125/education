import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WaitAndNotify wn = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer Thread started");
            wait();
            System.out.println("Producer Thread resumed");
        }

    }

    public void consume() throws InterruptedException
    {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);


        synchronized (this){
            System.out.println("Waiting for return key pressed ");
            scanner.nextLine();
            notify();
        }

    }
}