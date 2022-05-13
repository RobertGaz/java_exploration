package collections_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLesson {
    public static void main(String[] args) {
        int x[] = new int[3];
        for (int i = 0 ; i < 3; i++) {
            x[i] = i;
        }
        System.out.println(Arrays.toString(x));

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < 5; i++) {
            list.add(i);
        }

        System.out.println(list);


        list.remove(3);
        System.out.println(list);
    }
}
