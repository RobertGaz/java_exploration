// lesson 1

package multithreading_tutorial;

public class FirstLesson {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("*");
        Thread.sleep(1000);
        System.out.println("***");
        Thread.sleep(2000);

        Thread thread1 = new MyThread();
        Thread thread2 = new Thread(new Runner());
        thread1.start();
        thread2.start();

        System.out.println("(main thread) Hello!");

        thread1.join();
        thread2.join();
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("MOMENT");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("NASTAL");
            }
        };

        thread3.start();
    }

}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            System.out.println("(Runner) " + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            System.out.println("(MyThread) " + i);
        }
    }
}