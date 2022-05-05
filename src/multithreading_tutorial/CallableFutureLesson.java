// lesson 13

package multithreading_tutorial;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureLesson {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("(thread) i am started");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Random random = new Random();

                if (random.nextBoolean()) {
                    throw new Exception("Yoy!");
                }

                System.out.println("(thread) i am finished");

                return 5;
            }
        });

        executorService.shutdown();

        try {
            int okay = future.get();
            System.out.println("(main thread) returned from thread: " + okay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println("(main thread) got exception from thread: " + ex.getMessage());
        }

    }
}
