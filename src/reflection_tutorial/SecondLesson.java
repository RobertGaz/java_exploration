package reflection_tutorial;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecondLesson {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        final String class1_name = "reflection_tutorial.Person";
        final String class2_name = "java.lang.String";
        final String method_name = "setName";

        // Имя_класса_1 Имя_класса_2 Имя_метода
        Class class1 = Class.forName(class1_name);
        Class class2 = Class.forName(class2_name);

        // вытащим метод класса 1
        // который называется method_name и принимает на вход объект класса class2
        Method method = class1.getMethod(method_name, class2);

        // будет создан с пустым конструктором
        Object obj1 = class1.newInstance();
        // будет создан через конструктор, принимающий String, значение "kek"
        Object obj2 = class2.getConstructor(String.class).newInstance("kek");

        method.invoke(obj1, obj2);

        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);

    }
}
