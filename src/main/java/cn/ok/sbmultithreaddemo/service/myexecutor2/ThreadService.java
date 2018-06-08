package cn.ok.sbmultithreaddemo.service.myexecutor2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author kyou on 2018/6/7 23:41
 */
@Slf4j
@Service
public class ThreadService {

    @Async("MyExecutor2")
    public void doSth(int s) {
        log.debug("ThreadService doSth start.");

        try {
            log.debug("go to sleep {}s", s);
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("ThreadService doSth end.");
    }
}