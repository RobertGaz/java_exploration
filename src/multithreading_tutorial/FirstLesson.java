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
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            System.out.println("(runner) " + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
//            try {
//                Thread.sleep(100);
//            } catch(InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("(thread) " + i);
        }
    }
}