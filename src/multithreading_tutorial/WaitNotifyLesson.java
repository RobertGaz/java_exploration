// lesson 6

package multithreading_tutorial;

import java.util.Scanner;

public class WaitNotifyLesson {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();
        Thread produceThread = new Thread() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ;

        Thread consumeThread = new Thread() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("(producer) started");
            //вызывается на объекте this, так как на нем идет синхронизация
            wait(); // отдаем монитор (intrinsic lock)
            System.out.println("(producer) resumed after waiting");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            scanner.nextLine();
            notify();
        }
    }
}