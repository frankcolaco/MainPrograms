package com.examples.consumers;

import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {
        Consumer<String> strConsumer = s -> System.out.println(s);
        strConsumer.accept("Hello");
        Consumer<Integer> intConsumer = i -> System.out.println("integer value is: "+i);
        intConsumer.accept(1);


        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane");
        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from CA");
        consumer1.andThen(consumer2).accept("Hello. ");

    }
}
