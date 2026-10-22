package com.examples.interview.question.solution.tokenbucket.factory;


public final class TokenBucketFilterFactory {

    private TokenBucketFilterFactory(){}

    public static TokenBucketFilter makeTokenBucketFilter(int capacity){
        MultiThreadedTokenBucketFilter tbf = new MultiThreadedTokenBucketFilter(capacity);
        tbf.initialize();
        return tbf;
    }

    private static class MultiThreadedTokenBucketFilter extends TokenBucketFilter {

        private final int MAX_TOKENS;
        private long possibleTokens = 0;


        public MultiThreadedTokenBucketFilter(int capacity) {
            this.MAX_TOKENS = capacity;
        }

        /**
         * this method is used in factory after object creation to generate daemon threads.
         */
        void initialize() {
            Thread daemonThread = new Thread(this::daemonThread);
            daemonThread.setDaemon(true);
            daemonThread.start();
        }

        private void daemonThread() {
            while (true) {
                synchronized (this) {
                    if (possibleTokens < MAX_TOKENS) {
                        possibleTokens++;
                    }
                    this.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }
        }

        @Override
        void getToken() throws InterruptedException {
            synchronized (this) {
                while (possibleTokens == 0) {
                    this.wait();
                }
                possibleTokens--;
            }
            System.out.println(
                    "Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
        }
    }
}
