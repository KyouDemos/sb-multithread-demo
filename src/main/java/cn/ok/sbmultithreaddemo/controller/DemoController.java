package cn.ok.sbmultithreaddemo.controller;

import cn.ok.sbmultithreaddemo.service.myexecutor1.DemoServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kyou at 2018/6/7 06:22
 */
@Slf4j
@RestController
public class DemoController {

    /**
     * 自动注入实例
     */
    private final DemoServer demoServer;

    @Autowired
    public DemoController(DemoServer demoServer) {
        this.demoServer = demoServer;
    }

    @GetMapping("/doSth")
    public String doSth() {
        log.info("DemoController doSth start.");
        // controller => demoService(异步) => threadService(异步)
        demoServer.doSth();

        // controller => demoService(异步) => demoService(同步)
//        demoServer.doSth1();

        log.debug("doSth controller done.");
        return "doSth done.";
    }
}
