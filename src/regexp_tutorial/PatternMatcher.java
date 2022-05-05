// lesson 3

package regexp_tutorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        String regExp = "((\\w|\\d|-|\\.)*)@\\w+\\.((com|ru)|ge)";
        String text = " - Hi! I am Robert. My email: robert@gmail.com. " +
                " - Thanks Rob. My is alina@mail.ru!" +
                " - Okay. ";

        Pattern email = Pattern.compile(regExp);

        Matcher matcher = email.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(4));
        }
    }
}
