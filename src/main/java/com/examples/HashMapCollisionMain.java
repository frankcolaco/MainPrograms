package com.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapCollisionMain {
    public static void main(String[] args) {
        Map<CustomKey, String> dataMap = new HashMap<>();

        CustomKey keyOne = new CustomKey(2, "Alpha");
        CustomKey keyTwo = new CustomKey(4, "Beta");
        CustomKey keyThree = new CustomKey(3, "Gamma");

        dataMap.put(keyOne, "First Value");
        dataMap.put(keyTwo, "Second Value");
        dataMap.put(keyThree,"Third Value");

        System.out.println("Value for keyOne: " + dataMap.get(keyOne));
        System.out.println("Map size: " + dataMap.size());
    }
}

class CustomKey {
    private final int id;
    private final String name;

    public CustomKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomKey that = (CustomKey) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return id % 2;
    }
}
