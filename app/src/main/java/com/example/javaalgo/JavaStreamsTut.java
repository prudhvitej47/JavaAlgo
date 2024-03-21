package com.example.javaalgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsTut {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 5, 47, 2, 9, 3, 11, 22, 14);
        List<Float> floatArr = Arrays.asList(3.2f, 1.8f, 6.6f, 2.1f, 12.4f, 7.9f);
        List<String> strArr = Arrays.asList("Avatar", "Fernando", "Muddy", "Andy", "Alex", "Avatar", "DEMO");
        List<Person> objArr = Arrays.asList(Person.of("Avatar", 12), Person.of("Fred", 44), Person.of("Muddy", 56), Person.of("Andy", 14), Person.of("Alex", 23), Person.of("Avatar", 12));

        System.out.println(arr.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .values().stream()
                .toList()
        );

        // 1. Find the sum of all elements in a List using streams.
        System.out.println("Sum of all elements: " + arr.stream().mapToInt(i -> i).sum());

        // 2. Given a List of integers, write a program to find the maximum element using streams.
        System.out.println("Max element of stream: " + arr.stream().mapToInt(i -> i).max());

        // 3. Given a List of strings, write a program to count the number of strings that start with a specific character using streams.
        System.out.println("Count of strings that start with A: " + strArr.stream().filter(s -> s.startsWith("A")).count());

        // 4. Convert a List of strings to uppercase using streams.
        System.out.println("List of string with all strings in uppercase: " + strArr.stream().map(s -> s.toUpperCase()).toList());

        // 5. Given a List of integers, write a program to filter out the even numbers using streams.
        //    Count the number of elements in a list that satisfy a specific condition using streams.
        System.out.print("Even numbers in list: ");
        arr.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + ","));
        System.out.println("\nCount of even numbers in list: " + arr.stream().filter(i -> i % 2 == 0).count());

        // 6. Write a program to find the average of a List of floating-point numbers using streams.
        System.out.println("Average of floating point integer list: " + floatArr.stream().mapToDouble(i -> i).average().getAsDouble());

        // 7. Given a List of strings, write a program to concatenate all the strings using streams.
        System.out.println("Concatenated string: " + strArr.stream().collect(Collectors.joining(",")));

        // 8. Write a program to remove duplicate elements from a List using streams.
        System.out.println("String list with unique elements: " + strArr.stream().collect(Collectors.toSet()));
        System.out.println("String list with unique elements: " + strArr.stream().distinct().toList());

        // 9. Given a List of objects, write a program to sort the objects based on a specific attribute using streams.
        System.out.println("Sorted string list: " + strArr.stream().sorted(Comparator.comparing(s -> s)).toList());
        System.out.println("Sorted string list: " + strArr.stream().sorted(Comparator.naturalOrder()).toList());
        System.out.println("Sorted Person list: " + objArr.stream().sorted(Comparator.comparing(p -> p.getName())).toList());

        // 10. Write a program to check if all elements in a List satisfy a given condition using streams.
        System.out.println("Check if all elements are even: " + arr.stream().allMatch(i -> i % 2 == 0));

        // 11. Given a List of integers, write a program to find the difference between the maximum and minimum elements using streams.
        System.out.println("Difference between max and min: " + (arr.stream().mapToInt(i -> i).max().getAsInt() - arr.stream().mapToInt(i -> i).min().getAsInt()));

        // 12. Write a program to check if a List of strings contains at least one uppercase word using streams.
        System.out.println("Uppercase words in string list: " + strArr.stream().filter(s -> s.matches("[A-Z]*")).toList());

        // 13. Given a List of integers, write a program to filter out the prime numbers using streams.
        System.out.println("Prime numbers in list: " + arr.stream().filter(i -> isPrime(i)).toList());

        // 14. Write a program to check if a List of strings contains any duplicates using streams.
        System.out.println("Duplicates in string list: " +
                strArr.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                        .entrySet().stream()
                        .filter(e -> e.getValue() > 1)
                        .map(e -> e.getKey())
                        .toList()
        );
        System.out.println("Duplicates in string by count: " +
                strArr.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                        .entrySet().stream()
                        .filter(e -> e.getValue() > 1)
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()))
        );

        // 15. Given a List of strings, write a program to count the total number of characters in all strings using streams.
        System.out.println("Count the total number of characters in all strings using streams: " +
                strArr.stream().map(s -> s.length()).mapToInt(i -> i).sum());
        // using merge function to handle duplicates
        System.out.println("Count the total number of characters in each string using streams: " +
                strArr.stream().collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1)));


        //1. Given a sentence, find and print the frequency of each word.
        String sentence = "Java is a programming language. Java is versatile.";
        System.out.println("Frequency of each word in sentence: " +
                Arrays.stream(sentence.split(" "))
                        .map(s -> s.replace(".", ""))
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
        );

        //2. Given a list of integers, find out all the numbers starting with 1.
        System.out.println("List of numbers starting with 1: " + arr.stream().filter(i -> i.toString().startsWith("1")).toList());

        //3. Given a list of names, group them by their first letter, and then count the number of names in each group.
        System.out.println("Map of strings starting with same first letter: " +
                strArr.stream()
                        .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()))
        );

        // 7. How do you merge two sorted arrays into a single sorted array?
        var a1 = List.of(4, 8, 12, 18, 22, 87, 101);
        var a2 = List.of(1, 2, 9, 15, 33, 81, 99, 121);
        var concatArray = IntStream.concat(a1.stream().mapToInt(i -> i), a2.stream().mapToInt(i -> i))
                .sorted()
                .toArray();
        System.out.println("Merging 2 sorted arrays: " + Arrays.toString(concatArray));

        //8. Given two lists of strings, concatenate them and remove duplicates.
        List<String> s1 = List.of("apple", "banana", "orange");
        List<String> s2 = List.of("banana", "kiwi", "grape");
        System.out.println("Concatenated distinct string list" + Stream.concat(s1.stream(), s2.stream()).distinct().toList());

        // 9. Person Age Classification - 18 and above Major else Minor
        System.out.println("Classification of persons by age: " +
                objArr.stream().collect(Collectors.toMap(p -> p.getName(), p -> p.getAge() >= 18 ? "Major" : "Minor", (p1, p2) -> p1)));

        //10. Given a list of strings, sort them according to increasing order of their length.
        System.out.println("Strings sorted by length: " +
                strArr.stream()
                        .sorted(Comparator.comparingInt(s -> s.length()))
                        .toList()
        );

        //12.Partition a list of numbers into two groups: even and odd, using a custom predicate.
        System.out.println("List partitioned by even and odd numbers: " +
                arr.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0))
        );
        var partitionedMap = arr.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("List partitioned by even and odd numbers in descending order: True=" +
                partitionedMap.get(true).stream().sorted().toList() + ". False=" +
                partitionedMap.get(false).stream().sorted().toList()
        );
        System.out.println("Count of even and odd numbers in list: " +
                arr.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.counting()))
        );

        //13. Find the squares of the first three even numbers in a list.
        System.out.println("Squares of the first 3 even numbers in list: " +
                arr.stream()
                        .filter(i -> i % 2 == 0)
                        .limit(3)
                        .map(i -> i * i)
                        .toList()
        );

        // 14. Flatten a list of lists
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        System.out.println("Flattened list of lists: " +
                listOfLists.stream()
                        .flatMap(list -> list.stream())
                        .toList()
        );

        //Find the average length of strings in a list using streams.
        System.out.println("Average length of strings: " + strArr.stream().mapToInt(s -> s.length()).average().getAsDouble());

        //Find the longest string in a list using streams.
        System.out.println("Longest string in array: " + strArr.stream()
                .collect(Collectors.toMap(s -> s, s -> s.length(), (str1, str2) -> str1))
                .entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue()))
                .get().getKey()
        );

        //Find the second-smallest element in a list of integers using streams.
        // Using skip that skips first n elements
        System.out.println("Second largest element in list: " +
                arr.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .get()
        );

        int[] arrx = new int[]{0, 2, 3, 4};
        int n = arrx.length;
        System.out.println(((n*(n+1))/2) - Arrays.stream(arrx).sum());
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class Person {
        String name;
        Integer age;

        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        static Person of(String name, int age) {
            return new Person(name, age);
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}