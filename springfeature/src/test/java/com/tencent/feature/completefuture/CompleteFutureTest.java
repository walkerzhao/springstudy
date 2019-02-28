package com.tencent.feature.completefuture;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by andy on 2019/2/17.
 * demo例子参考:https://blog.csdn.net/z69183787/article/details/79974128
 */
public class CompleteFutureTest {

    @Test
    public void test() {
        System.out.println("hello");
    }


    @Test
    public void completedFutureExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    @Test
    public void runAsyncExample() throws InterruptedException {
        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().isDaemon());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(cf.isDone());
        Thread.sleep(1000);

        System.out.println(cf.isDone());


    }


    @Test
    public void thenApplyExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            System.out.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.out.println(cf.getNow(null));


    }

    @Test
    public void thenApplyAsyncExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().isDaemon());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.toUpperCase();
        });
        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }

    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "custom-executor-" + count++);
        }
    });

    @Test
    public void thenApplyAsyncWithExecutorExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName().startsWith("custom-executor-"));
            System.out.println(Thread.currentThread().isDaemon());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.toUpperCase();
        }, executor);
        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }

    @Test
    public void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(s -> result.append(s));
        System.out.println(result.length());
    }

    @Test
    public void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(s -> result.append(s));
        cf.join();
        System.out.println(result.length());
    }

    @Test
    public void completeExceptionallyExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
                executor);
        CompletableFuture exceptionHandler = cf.handle((s, th) -> {
            return (th != null) ? "message upon cancel" : "";
        });
        cf.completeExceptionally(new RuntimeException("completed exceptionally"));
        System.out.println(cf.isCompletedExceptionally());

        try {
            cf.join();
            System.out.println("Should have thrown an exception");
        } catch (CompletionException ex) { // just for testing
            System.out.println(ex.getCause().getMessage());

        }
        System.out.println(exceptionHandler.join());

    }


    @Test
    public void cancelExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
                executor);
        CompletableFuture cf2 = cf.exceptionally(throwable -> "canceled message");
        System.out.println(cf.cancel(true));
        System.out.println(cf.isCompletedExceptionally());
        System.out.println(cf2.join());
    }


    @Test
    public void applyToEitherExample() {
        String original = "Message";
        CompletableFuture cf1 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> {
                    try {
                        return delayedUpperCase(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return s;
                    }
                });
        CompletableFuture cf2 = cf1.applyToEither(
                CompletableFuture.completedFuture(original).thenApplyAsync(s -> delayedLowerCase(s)),
                s -> s + " from applyToEither");
        System.out.println(cf2.join());


    }




    private Object delayedLowerCase(String s) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

    private Object delayedUpperCase(String s) throws InterruptedException {
        Thread.sleep(200);
        return s;
    }
}
