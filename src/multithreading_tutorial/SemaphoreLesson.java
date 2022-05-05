// lesson 10

package multithreading_tutorial;

import java.util.concurrent.*;

public class SemaphoreLesson {

    public static void testSemaphore() {
        Semaphore semaphore = new Semaphore(3);

        try {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();

            System.out.println("*");

            semaphore.acquire();
            System.out.println("***"); // не бдует выведено

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Connection connection = Connection.getConnection();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWork();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;

    //максимум 3 потока могут подсоединиться одновременно
    private  Semaphore semaphore = new Semaphore(3);

    // Singleton
    private Connection() {

    }

    public static Connection getConnection() {
        return connection;
    }

    private void work() throws InterruptedException {

        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount + " connections");
        }

        Thread.sleep(3000);

        synchronized (this) {
            connectionsCount--;
        }

    }

    public void doWork() throws InterruptedException {
        semaphore.acquire();

        try {
            work();
        } finally {
            semaphore.release();
        }
    }
}