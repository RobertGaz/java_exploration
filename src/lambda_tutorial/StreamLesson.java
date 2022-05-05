// lesson 2

package lambda_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLesson {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        // map
        arr = Arrays.stream(arr).map(x -> x * 2).toArray();
        list = list.stream().map(x -> x * 2).collect(Collectors.toList());

        System.out.println("map result: " + Arrays.toString(arr));
        System.out.println("map result: " + list);

        // forEach
        list.forEach(x -> {
            int a = x * 10;
            System.out.print(a + " ");
        });
        System.out.println();


        // filter
        System.out.println("filter result: " + list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));



        List<Integer> list2 = new ArrayList<>();
        fillList(list2);

        // reduce
        Integer result = list2.stream().reduce((accumulator, x) -> accumulator + x).get();

        System.out.println("reduce result: " + result);




    }


    private static void fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    private static void fillList(List<Integer> list) {
        list.add(10);
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
    }
}
