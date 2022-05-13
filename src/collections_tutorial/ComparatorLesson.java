package collections_tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLesson {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("frog");
        animals.add("caaaaat");
        animals.add("parrot");
        animals.add("dog");

        Collections.sort(animals, new StringLengthComparator());
//        Collections.sort(animals, (a,b)->a.length()-b.length());
        System.out.println(animals);

    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}
