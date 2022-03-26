package com.example.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Qns:
 * 1. Thread vs process
 * 2. How does Runnable / subroutine exchange information with main thread?
 * 3. How to inform UI thread when child thread is done asynchronously?
 */

public class TestRunnable {
    public static void main(String[] args) {
        final String s = "immutables can be accessed by child thread";

        // only immutable objects can be accessed by main thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(s);
            }
        });

        // generic container to exchange data
        final Container<String> cs = new Container<>(s);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cs.set("dang containers are actually useful");
                System.out.println(cs.get());
            }
        });

        // message queues, handlers, loopers (android objects)
//        Looper uiLooper = Looper.getMainLooper(); // get the main looper
//        Handler handler = new Handler(uiLooper); // get the handler for the main thread
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //UI Thread will receive and run this
//                    }
//                });
//            }
//        });

        executor.shutdown();
    }
}

class Container<T> {
    T value;
    Container(T v) { this.value = v; }
    void set(T v) { this.value = v; }
    T get() { return this.value; }
}
