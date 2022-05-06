package reflection_tutorial;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class FirstLesson {
    public static void main(String[] args) {
        Class personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method: " + method.getName());
            System.out.println("parameterTypes: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("return type: " + method.getReturnType());
            System.out.println();
        }

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field: " + field.getName() + ", type: " + field.getType());
        }

        System.out.println();

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof CodeAuthor) {
                System.out.println("annotation: CodeAuthor");
            }
        }
    }
}
