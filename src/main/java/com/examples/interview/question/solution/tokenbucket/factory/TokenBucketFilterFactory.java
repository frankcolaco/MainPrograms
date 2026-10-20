package com.examples.interview.question.solution.tokenbucket.factory;


public final class TokenBucketFilterFactory {

    private TokenBucketFilterFactory(){}

    public static TokenBucketFilter makeTokenBucketFilter(int capacity){
        MultiThreadedTokenBucketFilter tbf = new MultiThreadedTokenBucketFilter(capacity);
        tbf.initialize();
        return tbf;
    }
}
