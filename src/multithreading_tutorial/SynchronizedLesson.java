//lesson 3

package multithreading_tutorial;

public class SynchronizedLesson {

    private int counter;

    public static void main(String[] args) {
        SynchronizedLesson test = new SynchronizedLesson();

        test.doWork();
    }

    public synchronized void increment_old() {
        counter = counter + 1;
    }

    public void increment() {

        synchronized (this) {
            counter = counter + 1;
        }

        // далее не синхронизировано
        System.out.println();
    }


    public void doWork() {
        Thread thread1 = new Thread(new Runnable () {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    counter++;
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable () {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    counter++;
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);

    }



}


