package com.rtc.manager;

import java.util.concurrent.*;

/**
 * @author ChenHang
 */
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 4, 30L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        threadPoolExecutor.prestartAllCoreThreads();

//        threadPoolExecutor.execute();
        Future<Object> submit = threadPoolExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "aaaa";
            }
        });
        Object o = submit.get();
        System.out.println(o.toString());

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Math.random());
//            }
//        });

    }
}
