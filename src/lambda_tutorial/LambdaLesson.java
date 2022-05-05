// lesson 1

package lambda_tutorial;

import java.util.*;

public class LambdaLesson {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("*");
            }
        };

        Runnable runnable2 = () -> System.out.println("*");


        int a = 2;
        Executable executable = new Executable() {
            @Override
            public int kek(String s) {
                // метод не видит внешнюю переменную a,
                // т.к. у него своя область видимости
                int a = 77;
                System.out.println(s);
                return a + 3;
            }
        };


        Executable executable2 = s -> {
//            int a = 9;
            System.out.println(s);
            return a + 3;
        };

        Comparator<Integer> comparator = (x, y) -> x - y;

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(-11); list.add(678); list.add(5);

        list.sort(comparator);
        // можно заменить лямбдой,так как у интерфейса Comparator лишь один метод
        list.sort((x,y) -> x-y);

        System.out.println(list);

    }
}

interface Executable {
    public int kek(String s);
}