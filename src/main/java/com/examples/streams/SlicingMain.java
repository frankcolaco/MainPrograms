package com.examples.streams;

import java.util.ArrayList;
import java.util.List;

public class SlicingMain {

    public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("China");
        countries.add("India");
        countries.add("UK");
        countries.add("China");

        countries.stream().distinct().forEach(System.out::println);

        System.out.println("======== limiting countries =========");
        countries.stream().distinct().limit(3).forEach(System.out::println);

        System.out.println("======== skipping countries =========");
        countries.stream().distinct().skip(2).forEach(System.out::println);
    }
}
