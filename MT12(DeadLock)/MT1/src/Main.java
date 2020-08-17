public class Main {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        myThread2.start();
//        myThread3.start();
//        myThread.start();

        Thread thread = new Thread(new Runner());
        thread.start();

    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from myThread" + i);
        }

    }
}
class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from myThread" + i);
        }
    }
}