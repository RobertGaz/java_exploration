// lesson 8

package multithreading_tutorial;

import java.util.concurrent.*;

public class CountDownLatchLesson {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));
        }

        executorService.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Latch opened.");
    }
}

class Processor implements Runnable {

    private final CountDownLatch countDownLatch;

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
