package practice;

import java.util.Arrays;

public class EnumClass {

    public enum Apple {
        num1("num1value"),
        num2("num2"),
        num3("num3");

        private final String value;
        Apple(String value)
        {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        System.out.println("number 1 : " + Apple.num1.name());
        String value = Apple.num1.value;
        System.out.println(Apple.valueOf("num2"));
        System.out.println("numbe value : " + value);

    }
}
