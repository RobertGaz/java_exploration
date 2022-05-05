// lesson 12

package multithreading_tutorial;

public class InterruptLesson {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("(thread) I am interrupted!");
                        break;
                    }
                    Math.sin(i);
                }
            }
        };

        System.out.println("Thread Start");
        thread.start();

        Thread.sleep(3000);
        thread.interrupt();

        thread.join();

        System.out.println("Thread End");
    }
}
