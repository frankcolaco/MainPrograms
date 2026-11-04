# MainPrograms

A Java learning repository of small, runnable programs covering core Java, functional programming, streams, concurrency, algorithms, and interview-style problems. It is organized as a sandbox for experimentation rather than a single application; most classes are standalone examples with their own `main` method.

## Overview

The repository includes examples for:

- Core Java fundamentals and utility patterns
- Multithreading, synchronization, and race-condition demos
- `CompletableFuture` and async composition patterns
- Java streams, collectors, and functional-style processing
- Lambda expressions and comparator-based processing
- Data structures and algorithmic problem solving
- Interview-style system design and concurrency challenges
- Date/time, optional values, and Java 21 language features

### Latest addition: multithreaded merge sort

The latest commit adds two merge-sort learning examples under `com.examples.algo.sorting`:

- `SingleThreadedMergeSort` demonstrates the standard recursive divide-and-conquer merge sort on a sample array.
- `MultiThreadedMergeSortDemo` generates a random array, sorts each half in a separate thread, and prints the before/after arrays and elapsed time.

These examples are intended for learning and experimentation; the multithreaded version is a concurrency demonstration rather than a production-grade performance optimization.

## Tech Stack

- Java 21
- Maven
- Spring Boot 3.5.3 parent project setup
- Lombok for boilerplate reduction

## Repository Structure

```text
MainPrograms/
├── .gitignore
├── README.md
├── pom.xml
└── src/main/java/com/examples/
    ├── algo/
    │   ├── patterns/
    │   │   ├── prefixsum/
    │   │   └── twopointers/
    │   │       ├── LongestSubstringMain.java
    │   │       ├── PalindromeMain.java
    │   │       ├── RemoveAllOccurrencesInArrayMain.java
    │   │       └── TwoSumMain.java
    │   ├── searching/
    │   └── sorting/
    ├── interview/question/solution/
    │   ├── superman/
    │   │   ├── BillPughSuperman.java
    │   │   ├── Superman.java
    │   │   ├── SupermanCorrectButSlow.java
    │   │   ├── SupermanNaiveButCorrect.java
    │   │   ├── SupermanSlightlyBetter.java
    │   │   └── SupermanWithFlaws.java
    │   ├── barrier/
    │   ├── deferredcallback/
    │   ├── diningphilosophers/
    │   ├── producerconsumer/
    │   ├── readwritelock/
    │   ├── semaphore/
    │   ├── tokenbucket/
    │   ├── uberseatingproblem/
    │   └── unisexbathroom/
    ├── collectors/
    ├── completables/
    ├── consumers/
    ├── function/
    ├── lambdas/
    ├── locks/
    ├── optional/
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
- `AuthorizationMain`

### Concurrency and thread safety
- `VoidMain`
- `DaemonThreadMain`
- `DeadLockDemo`
- `RaceConditionDemo`
- `ConcurrentModificationExceptionMain`
- `StampedLockBlockingMain`
- `StampedLockNonBlockingMain`
- `BarberShopProblemDemo`
- `DiningPhilosopherDemo`
- `DiningPhilosophersDemo2`
- Singleton initialization examples in `com.examples.interview.question.solution.superman`

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
- `RecordsMain`
- `SecondHighestMain`
- `SlicingMain`

### Asynchronous composition
- `CompletableFutureDemo`
- `CompletableChainingMain`
- `CompletableCombiningMain`
- `CompletableProcessingMain`
- `AreaOfRectangleMain`

### Lambdas and comparator patterns
- `CollectionsMain`
- `PersonMain`
- `RenewedComparatorMain`

### Algorithms and problem patterns
- Prefix sum strategies
- Two-pointer techniques, including `LongestSubstringMain`
- Binary search implementations
- Merge sort, quick sort, and heap sort

### Interview and system problem examples
- Producer/consumer demos
- Read/write lock and semaphore patterns
- Deferred callback and token bucket implementations
- Busy wait and lock-based solutions
- Barber shop customer/barber coordination simulation
- Uber seating and unisex bathroom simulations
- Barrier coordination patterns
- Dining philosophers deadlock and starvation avoidance demos
- Singleton implementation and thread-safety comparisons

## Prerequisites

- JDK 21 or later
- Maven 3.9+
- An IDE like IntelliJ IDEA or VS Code (optional)

## Build

From the project root:

```bash
mvn clean compile
```

## Run a demo

Each example class can generally be run individually if it contains a `main` method. For example:

```bash
mvn exec:java -Dexec.mainClass="com.examples.algo.patterns.twopointers.LongestSubstringMain"
```

If `exec-maven-plugin` is not configured, run the class directly from the IDE or compile it and execute the generated class file with `java`.

## Notes

- This repository is intended for learning and experimentation.
- It contains many independent Java demos rather than a single user-facing application.
- Use it as a reference for Java language features, functional APIs, concurrency patterns, and algorithmic problem solving.

## License

This repository does not currently declare a specific license file in the root. Please check with the repository owner before using it in production or publishing derivatives.
