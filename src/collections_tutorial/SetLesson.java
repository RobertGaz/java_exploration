package collections_tutorial;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetLesson {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        testSet(hashSet);
        testSet(linkedHashSet);
        testSet(treeSet);
    }

    private static void testSet(Set<String> set) {
        set.add("Bob");
        set.add("Alice");
        set.add("Mike");
        set.add("Kek");
        set.add("Aline");

        System.out.println(set.getClass());
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
    }


}
