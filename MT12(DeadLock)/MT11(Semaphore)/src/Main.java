import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3 );
        try {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();

            System.out.println("All permits have been acquired ");
            semaphore.acquire();
            System.out.println("Can't reach here ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(semaphore.availablePermits());
    }
}
