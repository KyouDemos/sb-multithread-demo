package cn.ok.sbmultithreaddemo.service.myexecutor1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

/**
 * @author kyou on 2018/6/9 15:55
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoServerTest {

    @Autowired
    DemoServer demoServer;

    @Test
    public void doSth() {
        CompletableFuture<String> rtn1 = demoServer.doSth();
        CompletableFuture<String> rtn2 = demoServer.doSth();
        CompletableFuture.allOf(rtn1, rtn2).join();

        log.debug("DemoServerTest - doSth() done.");
    }

    @Test
    public void doSth1() {
    }

    @Test
    public void doSth2() {
    }
}