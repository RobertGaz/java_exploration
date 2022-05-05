// lesson 7


package multithreading_tutorial;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerLesson2 {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        Thread produceThread = new Thread() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread consumeThread = new Thread() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        produceThread.start();
        consumeThread.start();

        produceThread.join();
        consumeThread.join();
    }

}

class ProducerConsumer {

    // сами сделаем потокобезопасную очередь
    private final Queue queue = new LinkedList<>();
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {
                while (queue.size() >= 10) {
                    lock.wait();
                }

                queue.offer(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                System.out.println("(consumer) consumed " + queue.poll());
                System.out.println("(consumer) queue size: " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);


        }
    }
}
