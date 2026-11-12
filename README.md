# MainPrograms

A Java learning repository of small, runnable programs covering core Java, functional programming, streams, concurrency, algorithms, and interview-style problems. It is organized as a sandbox for exploring Java language features and common programming patterns.

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

### Recent additions and package updates

The repository includes merge-sort learning examples under `com.examples.algo.sorting`:

- `SingleThreadedMergeSort` demonstrates recursive divide-and-conquer merge sort.
- `MultiThreadedMergeSortDemo` sorts two array halves in separate threads and reports the before/after arrays and elapsed time. It is a concurrency demonstration, not a production-grade performance optimization.

The interview printing examples now also include a synchronized multithreaded FizzBuzz implementation under `com.examples.interview.question.solution.printing.fizzbuzz`:

- `MultiThreadedFizzBuzz` coordinates printing numbers, Fizz, Buzz, and FizzBuzz.
- `FizzBuzzThread` runs one of the printing tasks.
- `MultiThreadedFizzBuzzDemo` starts the four worker threads.

The synchronous printing classes use the corrected `printing.synchronously` package and directory (rather than the former `print.synchronously` path).

## Tech Stack

- Java 21
- Maven
- Spring Boot 3.5.3 parent project setup
- Lombok for boilerplate reduction

## Repository Structure

This tree reflects the repository's current `main` branch layout, including the latest printing examples and the corrected `printing/synchronously` package path.

```text
MainPrograms/
├── .gitignore
├── README.md
├── pom.xml
└── src/main/java/com/examples/
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
    │   │       ├── LongestSubstringMain.java
    │   │       ├── PalindromeMain.java
    │   │       ├── RemoveAllOccurrencesInArrayMain.java
    │   │       └── TwoSumMain.java
    │   ├── searching/binary_search/
    │   │   ├── ArmStrongNumber.java
    │   │   ├── BinarySearchIterative.java
    │   │   ├── BinarySearchRecursive.java
    │   │   └── FirstBadVersion.java
    │   └── sorting/
    │       ├── HeapSortMain.java
    │       ├── MergeSortMain.java
    │       ├── MultiThreadedMergeSortDemo.java
    │       ├── QuickSortMain.java
    │       └── SingleThreadedMergeSort.java
    ├── binary/BinaryOpMain.java
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
    ├── consumers/ConsumerMain.java
    ├── function/
    │   ├── BiFunctionMain.java
    │   └── FunctionMain.java
    ├── interview/question/solution/
    │   ├── BusyWaitSolUsingLockDemo.java
    │   ├── ListingDedupService.java
    │   ├── MissingNumberMain.java
    │   ├── asynctosync/
    │   │   ├── AsyncDemo.java
    │   │   ├── AsyncToSyncDemo.java
    │   │   ├── Callback.java
    │   │   ├── Executor.java
    │   │   └── SynchronousExecutor.java
    │   ├── barbershop/
    │   │   ├── BarberShopProblem.java
    │   │   ├── BarberShopProblemDemo.java
    │   │   ├── BarberShopProblemUsingBlockingQueue.java
    │   │   └── BarberShopProblemUsingBlockingQueueDemo.java
    │   ├── barrier/
    │   │   ├── Barrier.java
    │   │   └── BarrierDemo.java
    │   ├── deferredcallback/
    │   │   ├── DeferredCallBackDemo.java
    │   │   └── DeferredCallbackExecutor.java
    │   ├── diningphilosophers/
    │   │   ├── DiningPhilosopherDemo.java
    │   │   ├── DiningPhilosophers.java
    │   │   ├── DiningPhilosophersDemo2.java
    │   │   └── DiningPhilosophersSol2.java
    │   ├── molecule/
    │   │   ├── H2OMachine.java
    │   │   ├── H2OMachineThread.java
    │   │   └── MoleculeDemo.java
    │   ├── printing/
    │   │   ├── fizzbuzz/
    │   │   │   ├── FizzBuzzThread.java
    │   │   │   ├── MultiThreadedFizzBuzz.java
    │   │   │   └── MultiThreadedFizzBuzzDemo.java
    │   │   ├── numberseries/
    │   │   │   ├── PrintNumberSeries.java
    │   │   │   ├── PrintNumberSeriesDemo.java
    │   │   │   ├── PrintNumberSeriesThread.java
    │   │   │   └── PrintingNumberSeries.java
    │   │   ├── order/
    │   │   │   ├── CDOrderPrinting.java
    │   │   │   ├── ClassicOrderPrinting.java
    │   │   │   ├── CountDownOrderPrinting.java
    │   │   │   ├── OrderPrinting.java
    │   │   │   └── OrderPrintingThread.java
    │   │   └── synchronously/
    │   │       ├── FooBar.java
    │   │       ├── FooBarThread.java
    │   │       └── PrintSynchronously.java
    │   ├── producerconsumer/
    │   │   ├── CountingSemaphore.java
    │   │   ├── ProducerConsumerDemo.java
    │   │   └── ProducerConsumerSemaphoreDemo.java
    │   ├── readwritelock/
    │   │   ├── ReadWriteLock.java
    │   │   └── ReadWriteLockDemo.java
    │   ├── semaphore/
    │   │   ├── CountingSemaphore.java
    │   │   └── CountingSemaphoreDemo.java
    │   ├── stack/
    │   │   ├── StackNode.java
    │   │   ├── atomic/
    │   │   │   ├── AtomicStackDemo.java
    │   │   │   └── NonBlockingStack.java
    │   │   ├── cas/
    │   │   │   ├── CASDemo.java
    │   │   │   └── SimulatedCompareAndSwap.java
    │   │   └── synchronize/
    │   │       ├── SynchronizedStack.java
    │   │       └── SynchronizedStackDemo.java
    │   ├── superman/
    │   │   ├── BillPughSuperman.java
    │   │   ├── Superman.java
    │   │   ├── SupermanCorrectButSlow.java
    │   │   ├── SupermanNaiveButCorrect.java
    │   │   ├── SupermanSlightlyBetter.java
    │   │   └── SupermanWithFlaws.java
    │   ├── tokenbucket/
    │   │   ├── MultiThreadedTokenBucketFilterDemo.java
    │   │   ├── TokenBucketFilterDemo.java
    │   │   └── factory/
    │   │       ├── TokenBucketFilter.java
    │   │       ├── TokenBucketFilterFactory.java
    │   │       └── TokenBucketMultiThreadedFactoryDemo.java
    │   ├── uberseatingproblem/
    │   │   ├── UberSeatingProblem.java
    │   │   └── UberSeatingProblemDemo.java
    │   └── unisexbathroom/
    │       ├── UnisexBathroom.java
    │       └── UnisexBathroomDemo.java
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
    ├── optional/OptionalMain.java
    ├── pojo/Employee.java
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
    ├── suppliers/SupplierMain.java
    ├── time/
    │   ├── DateDemo.java
    │   ├── DateTimeDemo.java
    │   ├── PeriodDurationDemo.java
    │   ├── TimeDemo.java
    │   └── ZoneDateTimeDemo.java
    └── unary/UnaryOpMain.java
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
- Multithreaded FizzBuzz and ordered printing examples
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
