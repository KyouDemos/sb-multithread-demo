package cn.ok.sbmultithreaddemo.normaldemo;

import lombok.extern.slf4j.Slf4j;

/**
 * File Header
 * PROJECT_NAME: sb-multithread-demo
 * PACKAGE_NAME: cn.ok.sbmultithreaddemo.normaldemo
 * @author kyou on 2018/6/8 16:49.
 */
@Slf4j
public class WorkThread implements Runnable {

    private int cnt;

    WorkThread(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        log.info("WorkThread start, cnt: {}", cnt);
        try {
            Thread.sleep(1000 * cnt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("WorkThread end, cnt: {}", cnt);
    }
}
