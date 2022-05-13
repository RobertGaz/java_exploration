package collections_tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterable {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(3);

        for (int i = 0; i < 4; i++) {
            if (i==2) {
                list.add(44);
            }
        }

        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (i == 1) {
                iterator.remove();
            }
            i++;
        }

        System.out.println(list);
    }
}
