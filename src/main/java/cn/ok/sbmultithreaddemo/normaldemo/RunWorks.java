package cn.ok.sbmultithreaddemo.normaldemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * File Header
 * PROJECT_NAME: sb-multithread-demo
 * PACKAGE_NAME: cn.ok.sbmultithreaddemo.normaldemo
 * Created by wangqiang on 2018/6/8 16:53.
 */
@Slf4j
public class RunWorks {
    public static void main(String[] args) throws InterruptedException {
        log.info("RunWorks Start.");

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        executor.submit(new WorkThread(1));
        executor.submit(new WorkThread(2));

        // 等待子线程执行完成
        executor.shutdown();
        // 最大等待时间（1h）
        executor.awaitTermination(1, TimeUnit.HOURS);

        log.info("RunWorks End.");
    }
}
