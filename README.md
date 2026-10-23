# MainPrograms

A Java-based collection of small, runnable examples covering core Java, concurrency, functional programming, data structures, and algorithmic problem solving.

This repository is organized as a learning sandbox rather than a single business application. Each class is designed to demonstrate a specific Java concept or coding pattern and usually contains its own `main` method for execution.

## Overview

This project includes examples for:

- Core Java concepts and utilities
- Multithreading and synchronization
- Java streams and lambda expressions
- Java 21 language features and standard library usage
- Data structures and algorithm patterns
- Interview-style concurrency and system-design problem examples
- Functional interfaces such as `Predicate`, `Function`, `Supplier`, and `UnaryOperator`
- Time/date handling and optional values

## Tech Stack

- Java 21
- Maven
- Spring Boot 3.5.3 parent project setup
- Lombok for boilerplate reduction

## Repository Structure

```text
MainPrograms/
├── .gitignore
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/examples/
                ├── AuthorizationMain.java
                ├── ConcurrentModificationExceptionMain.java
                ├── DaemonThreadMain.java
                ├── DateStringMain.java
                ├── DeadLockDemo.java
                ├── ExceptionDescriptionExtraction.java
                ├── HashMapCollisionMain.java
                ├── Main.java
                ├── MissingNumbersMain.java
                ├── RaceConditionDemo.java
                ├── VoidMain.java
                ├── algo/
                │   ├── patterns/
                │   │   ├── prefixsum/
                │   │   └── twopointers/
                │   ├── searching/
                │   └── sorting/
                ├── binary/
                ├── collectors/
                ├── completables/
                ├── consumers/
                ├── function/
                ├── interview/
                ├── lambdas/
                ├── locks/
                ├── optional/
                ├── pojo/
                ├── predicates/
                ├── streams/
                ├── suppliers/
                ├── time/
                └── unary/
```

## Example Topics Included

### Core Java and utilities
- `DateStringMain`
- `HashMapCollisionMain`
- `MissingNumbersMain`
- `ExceptionDescriptionExtraction`

### Concurrency and thread safety
- `VoidMain`
- `DaemonThreadMain`
- `DeadLockDemo`
- `RaceConditionDemo`
- `ConcurrentModificationExceptionMain`
- `StampedLockBlockingMain`
- `StampedLockNonBlockingMain`

### Functional programming
- `FunctionMain`
- `BiFunctionMain`
- `PredicateMain`
- `BiPredicateMain`
- `SupplierMain`
- `UnaryOpMain`
- `BinaryOpMain`

### Streams and collection processing
- `StreamsMapDemo`
- `StreamsFilterDemo`
- `StreamsFlatMapDemo`
- `StreamsReduceOpMain`
- `StreamsMatchingOpsMain`
- `StreamsFindingOpsMain`
- `CollectorsDemoMain`
- `CollectorsAggregatorOpsMain`
- `CollectorsGroupingOpsMain`

### Algorithms and problem patterns
- Prefix sum techniques
- Two-pointer solutions
- Binary search examples
- Merge sort, quick sort, heap sort

### Interview / system problem examples
- Producer/consumer demos
- Read/write lock examples
- Deferred callback and token bucket implementations
- Busy wait / locking patterns

## Prerequisites

- JDK 21 or later
- Maven 3.9+
- An IDE such as IntelliJ IDEA or VS Code (optional)

## Build

From the project root:

```bash
mvn clean compile
```

## Run a demo

Each example class can be run individually if it contains a `main` method. For example:

```bash
mvn exec:java -Dexec.mainClass="com.examples.VoidMain"
```

If `exec-maven-plugin` is not configured in the project, you can also run a class directly from the IDE or package it first and execute the generated class file with `java`.

## Notes

- This repository is intended for learning and experimentation.
- It contains many independent Java demos rather than a single user-facing application.
- Use it as a reference for Java language features, algorithm patterns, and threading examples.

## License

This repository does not currently declare a specific license file in the root. Please check with the repository owner before using it in production or publishing derivatives.
