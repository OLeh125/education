import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            Random random = new Random();
            @Override
            public Integer call() throws Exception {

                Thread.sleep(500);
                int randomValue = random.nextInt();
                if (randomValue<5)throw new Exception("Something bad happened");
                return random.nextInt(10);
            }
        });

        executorService.shutdown();
        try{
            int result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
