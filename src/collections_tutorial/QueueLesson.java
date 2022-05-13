package collections_tutorial;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLesson {
    public static void main(String[] args) {

        Queue<Integer> carsQueue = new LinkedList<>();

        carsQueue.add(3);
        carsQueue.add(2);
        carsQueue.add(4);
        carsQueue.add(1);

        for (int car : carsQueue) {
            System.out.println(car);
        }

        System.out.println("*****");

        System.out.println(carsQueue.remove());
        System.out.println(carsQueue.peek());

    }
}
