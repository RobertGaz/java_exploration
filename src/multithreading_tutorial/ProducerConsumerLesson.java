// lesson 5

package multithreading_tutorial;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerLesson {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);;

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while(true) {
            // если очередь полная, ждет пока освободится место (ждет в смысле sleep)
            queue.put(random.nextInt(100));
        }
    }

    private static void consume() throws InterruptedException {
        while(true) {
            Thread.sleep(100);

            // если очередь пустая, ждет новых элементов (ждет в смысле sleep)
            System.out.println("(consumer) value: " + queue.take());
            System.out.println("(consumer) queue size: " + queue.size());
        }
    }
}
