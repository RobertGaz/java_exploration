// lesson 2

package regexp_tutorial;

import java.util.Arrays;

public class SplitReplace {
    public static void main(String[] args) {
        String a = "ya vizhu svet";
        String[] words = a.split(" ");
        System.out.println(Arrays.toString(words));

        String b = "yoy46783sus6789LUL00000";
        words = b.split("\\d+");
        System.out.println(Arrays.toString(words));


        String c = "oh, chto za den takoy";
        c = c.replace("oh", "OHH...");
        System.out.println(c);

        String d = "sap829932chto za den takoy";
        d = d.replaceAll("\\w+\\d+\\w+", "REPLACED");
        System.out.println(d);

        String e = "chto111za222den333takoy";
        e = e.replaceFirst("\\d+", "-");
        System.out.println(e);
    }
}