// lesson 4

package multithreading_tutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolLesson {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }

        executorService.shutdown();

        System.out.println("(main) Прием заявок закрыт");

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }

        System.out.println("(main) FIN");
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("(thread) Work " + id + " completed.");
    }
}
