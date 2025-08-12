package com.examples.predicates;

import com.examples.lambdas.comparator.Person;

import java.util.function.Predicate;

public class PredicateMain {


    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    static boolean isPersonEligibleForClubMembership(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    static boolean isPersonAgeAboveSixty(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    public static void main(String[] args) {

        Person person = new Person("Alex",23,"CA");
        Person person2 = new Person("Bob",60,29);
        Predicate<Person> votingEligibilityPredicateP1 = person1 -> person1.getAge() > 18;

        Predicate<Person> clubMembershipPredicateP1 = person1 -> person1.getAge() < 60;

        Predicate<Person> eligibilityPredicateP1 = votingEligibilityPredicateP1.and(clubMembershipPredicateP1);

        Predicate<Person> eligibilityRetirementPredicateP2 = person1 -> person1.getYearOfService() > 30;
        Predicate<Person> ageAboveSixtyPredicateP2 = person1 -> person1.getAge() > 60;

        boolean isEligibleForVoting = isPersonEligibleForVoting(person, votingEligibilityPredicateP1);
        System.out.println("Eligible for voting: " + isEligibleForVoting);

        boolean isEligibleForMembership = isPersonEligibleForClubMembership(person, eligibilityPredicateP1);
        System.out.println("Eligible for club membership: " + isEligibleForMembership);

        boolean isEligibleForRetirement = isPersonAgeAboveSixty(person2, ageAboveSixtyPredicateP2.or(eligibilityRetirementPredicateP2));
        System.out.println("Eligible for retirement: " + isEligibleForRetirement);



    }
}
