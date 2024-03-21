package com.example.javaalgo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaFunctionalInterfaces {

    @FunctionalInterface
    public interface Foo {
        String add(String str);
    }

    public static String addFoo(String str, Foo foo) {
        return foo.add(str);
    }

    public static String addFoo(String str, Function<String, String> fn) {
        return fn.apply(str);
    }

    public static void main(String[] args) {
        Foo temp = (str) -> str + " Hello!!";
        System.out.println(addFoo("Prudhvi", temp));

        System.out.println(addFoo("John", new Foo() {
            @Override
            public String add(String str) {
                return str + " Namaste!!";
            }
        }));

        Function<String, String> temp2 = (str) -> str + " Hi!!";
        System.out.println(addFoo("Ram", temp2));
        System.out.println(temp2.apply("Sita"));

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Andy", "Sales");
        hashMap.put("Dwight", "Assistant to the Regional Manager");
        hashMap.put("Angela", "Accounting");
        hashMap.put("Michael", "Regional Manager");
        hashMap.put("Pam", "Receptionist");
        hashMap.get("Angela");
        System.out.println();
    }
}
