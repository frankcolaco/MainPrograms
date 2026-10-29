# MainPrograms

A Java-based learning repository containing small, runnable programs that demonstrate core Java concepts, functional programming, streams, concurrency, algorithms, and interview-style concurrency problems.

This project is organized as a sandbox for experimentation rather than a single application. Most classes are standalone examples with their own `main` method and focus on one concept at a time.

## Overview

The repository now includes examples for:

- Core Java fundamentals and utility patterns
- Multithreading, synchronization, and race-condition demos
- `CompletableFuture` and async composition patterns
- Java streams, collectors, and functional-style processing
- Lambda expressions and comparator-based processing
- Data structures and algorithmic problem solving
- Interview-style system design and concurrency challenges
- Date/time, optional values, and Java 21 language features

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
                │   │   │   ├── ArrayToEqSubArrayMain.java
                │   │   │   ├── EquilibriumMain.java
                │   │   │   ├── MeanOfRangeInArrayMain.java
                │   │   │   ├── OriginalArrayFromPrefixSumMain.java
                │   │   │   ├── RangeSumArrayMain.java
                │   │   │   └── SubArraySumEqKMain.java
                │   │   └── twopointers/
                │   │       ├── PalindromeMain.java
                │   │       ├── RemoveAllOccurrencesInArrayMain.java
                │   │       └── TwoSumMain.java
                │   ├── searching/
                │   │   ├── BinarySearchIterative.java
                │   │   └── BinarySearchRecursive.java
                │   └── sorting/
                │       ├── HeapSortMain.java
                │       ├── MergeSortMain.java
                │       └── QuickSortMain.java
                ├── binary/
                │   └── BinaryOpMain.java
                ├── collectors/
                │   ├── CollectorsAggregatorOpsMain.java
                │   ├── CollectorsDemoMain.java
                │   └── CollectorsGroupingOpsMain.java
                ├── completables/
                │   ├── AreaOfRectangleMain.java
                │   ├── CompletableChainingMain.java
                │   ├── CompletableCombiningMain.java
                │   ├── CompletableFutureDemo.java
                │   └── CompletableProcessingMain.java
                ├── consumers/
                │   └── ConsumerMain.java
                ├── function/
                │   ├── BiFunctionMain.java
                │   └── FunctionMain.java
                ├── interview/
                │   └── question/
                │       └── solution/
                │           ├── BusyWaitSolUsingLockDemo.java
                │           ├── ListingDedupService.java
                │           ├── MissingNumberMain.java
                │           ├── barrier/
                │           │   ├── Barrier.java
                │           │   └── BarrierDemo.java
                │           ├── deferredcallback/
                │           │   ├── DeferredCallBackDemo.java
                │           │   └── DeferredCallbackExecutor.java
                │           ├── diningphilosophers/
                │           │   ├── DiningPhilosopherDemo.java
                │           │   ├── DiningPhilosophers.java
                │           │   ├── DiningPhilosophersDemo2.java
                │           │   └── DiningPhilosophersSol2.java
                │           ├── producerconsumer/
                │           │   ├── CountingSemaphore.java
                │           │   ├── ProducerConsumerDemo.java
                │           │   └── ProducerConsumerSemaphoreDemo.java
                │           ├── readwritelock/
                │           │   ├── ReadWriteLock.java
                │           │   └── ReadWriteLockDemo.java
                │           ├── semaphore/
                │           │   ├── CountingSemaphore.java
                │           │   └── CountingSemaphoreDemo.java
                │           ├── tokenbucket/
                │           │   ├── MultiThreadedTokenBucketFilterDemo.java
                │           │   ├── TokenBucketFilterDemo.java
                │           │   └── factory/
                │           │       ├── TokenBucketFilter.java
                │           │       ├── TokenBucketFilterFactory.java
                │           │       └── TokenBucketMultiThreadedFactoryDemo.java
                │           ├── uberseatingproblem/
                │           │   ├── UberSeatingProblem.java
                │           │   └── UberSeatingProblemDemo.java
                │           └── unisexbathroom/
                │               ├── UnisexBathroom.java
                │               └── UnisexBathroomDemo.java
                ├── lambdas/
                │   ├── CollectionsMain.java
                │   └── comparator/
                │       ├── Person.java
                │       ├── PersonMain.java
                │       ├── PersonService.java
                │       └── RenewedComparatorMain.java
                ├── locks/
                │   ├── StampedLockBlockingMain.java
                │   └── StampedLockNonBlockingMain.java
                ├── optional/
                │   └── OptionalMain.java
                ├── pojo/
                │   └── Employee.java
                ├── predicates/
                │   ├── BiPredicateMain.java
                │   └── PredicateMain.java
                ├── streams/
                │   ├── Employee.java
                │   ├── RecordsMain.java
                │   ├── SecondHighestMain.java
                │   ├── SlicingMain.java
                │   ├── StreamsFilterDemo.java
                │   ├── StreamsFindingOpsMain.java
                │   ├── StreamsFlatMapDemo.java
                │   ├── StreamsMapDemo.java
                │   ├── StreamsMatchingOpsMain.java
                │   └── StreamsReduceOpMain.java
                ├── suppliers/
                │   └── SupplierMain.java
                ├── time/
                │   ├── DateDemo.java
                │   ├── DateTimeDemo.java
                │   ├── PeriodDurationDemo.java
                │   ├── TimeDemo.java
                │   └── ZoneDateTimeDemo.java
                └── unary/
                    └── UnaryOpMain.java
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
- `DiningPhilosopherDemo`
- `DiningPhilosophersDemo2`

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
- Two-pointer techniques
- Binary search implementations
- Merge sort, quick sort, and heap sort

### Interview and system problem examples
- Producer/consumer demos
- Read/write lock and semaphore patterns
- Deferred callback and token bucket implementations
- Busy wait and lock-based solutions
- Uber seating and unisex bathroom simulations
- Barrier coordination patterns
- Dining philosophers deadlock and starvation avoidance demos

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
mvn exec:java -Dexec.mainClass="com.examples.VoidMain"
```

If `exec-maven-plugin` is not configured, you can run the class directly from the IDE or compile it and execute the generated class file with `java`.

## Notes

- This repository is intended for learning and experimentation.
- It contains many independent Java demos rather than a single user-facing application.
- Use it as a reference for Java language features, functional APIs, concurrency patterns, and algorithmic problem solving.

## License

This repository does not currently declare a specific license file in the root. Please check with the repository owner before using it in production or publishing derivatives.
