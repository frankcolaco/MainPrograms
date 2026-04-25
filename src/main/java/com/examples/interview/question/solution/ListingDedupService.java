package com.examples.interview.question.solution;

import java.util.*;

/**
 *Imagine you’re building a Spring Boot service for an e-commerce marketplace.
 * Sellers sometimes try to game the search ranking by posting multiple listings with the same words in a different order.
 * Example product titles:
 * "wireless mouse"
 * "mouse wireless"
 * "silent wireless mouse"
 * The moderation team wants to group titles that contain the same words, regardless of the order.
 */
public class ListingDedupService {

    public static void main(String[] args) {

        ListingDedupService listingDedupService = new ListingDedupService();
        List<String> titles = List.of("wireless mouse","mouse wireless","silent wireless mouse");
        System.out.println(listingDedupService.groupSimilarTitles(titles));

    }

    public List<List<String>> groupSimilarTitles(List<String> titles){
        Map<String,List<String>> groups = new HashMap<>();
        for(String title: titles){
            String[] words = title.toLowerCase().split(" ");
            Arrays.sort(words);
            String signature = String.join(" ",words);
            groups.computeIfAbsent(signature,k -> new ArrayList<>()).add(title);
        }
        return new ArrayList<>(groups.values());
    }


}
