package net.hydonclient.installer.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Multithreading {

    private static AtomicInteger COUNT = new AtomicInteger();
    private static ExecutorService EXECUTOR = Executors.newFixedThreadPool(100, r -> new Thread(r, "Multithread-" + COUNT.getAndIncrement()));

    public static void run(Runnable r) {
        EXECUTOR.execute(r);
    }

}
