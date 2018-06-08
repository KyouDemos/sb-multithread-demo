package cn.ok.sbmultithreaddemo.service.myexecutor1;

import cn.ok.sbmultithreaddemo.service.myexecutor2.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author kyou at 2018/6/7 06:29
 */
@Slf4j
@Service
public class DemoServer {

    /**
     * 在异步线程内自动注入实例的示例可以被正常初始化
     */
    private ThreadService threadService;

    @Autowired
    public DemoServer(ThreadService threadService) {
        this.threadService = threadService;
    }

    @Async
    public void doSth() {
        log.debug("DemoServer doSth start.");

        // 调用不同实例的异步方法，将会异步执行。
        threadService.doSth(1);
        threadService.doSth(3);

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("DemoServer doSth end.");
    }

    @Async
    public void doSth1() {
        log.debug("DemoServer doSth1 start.");

        // 虽然doSth2()是异步方法，但是调用同一个实例中的异步方法，并不会异步执行。
        doSth2();
        doSth2();

        log.debug("DemoServer doSth1 end.");
    }

    @Async
    public void doSth2(){

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.debug("DemoServer doSth2.");
    }
}
