package cn.ok.sbmultithreaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author kyou at 2018-06-08 00:36:28
 */

@EnableAsync
@SpringBootApplication
public class SbMultiThreadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbMultiThreadDemoApplication.class, args);
    }
}
