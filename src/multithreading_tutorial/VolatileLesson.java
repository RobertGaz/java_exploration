// lesson 2

package multithreading_tutorial;

import java.util.Scanner;

public class VolatileLesson {
    public static void main(String[] args) {

        VolatileThread thread = new VolatileThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);

        // ждет ввода новой строки
        scanner.nextLine();

        thread.shutDown();
    }

}

class VolatileThread extends Thread {

    // Поток main пишет в это поле, а поток VolatileThread читает.
    private boolean isActive = true;

    public void run() {
        while (isActive) {
            System.out.println("***");
        }

    }

    public void shutDown() {
        isActive = false;
    }
}
