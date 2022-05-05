// lesson 9

package multithreading_tutorial;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockLesson {
    public static void main(String[] args) {
        Task task = new Task();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                task.firstThread();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                task.secondThread();
            }
        };

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(task.getCounter());
    }
}

class Task {

    private int counter;
    private Lock lock = new ReentrantLock();

    public int getCounter() {
        return counter;
    }

    private void increment() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }
}
