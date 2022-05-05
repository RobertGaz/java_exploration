// lesson 1

package regexp_tutorial;

public class FirstLesson {
    public static void main(String[] args) {
        String a = "-123";
        System.out.println(a.matches("(-|\\+)?\\d+"));

        String b = "yoy0001aiai4579453";
        System.out.println(b.matches("\\w\\d+"));
        System.out.println(b.matches("[a-zA-Z0-1]+\\d+"));

        String c = "hvnins110";
        System.out.println(c.matches("[^abc]*"));

        String d = "www.myhome.ge";
        System.out.println(d.matches("www\\..+\\.(com|ru|ge)"));

        String e = "7236467";
        System.out.println(e.matches("\\d{2,}"));
    }
}