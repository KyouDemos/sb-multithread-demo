package cn.ok.sbmultithreaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kyou at 2018-06-08 00:36:28
 */

@EnableAsync
@SpringBootApplication
public class SbMultiThreadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbMultiThreadDemoApplication.class, args);
    }

    @Bean(name = "MyExecutor2")
    public Executor initMyExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 设置核心线程池大小
        executor.setCorePoolSize(2);
        // 设置核心线程池的等待队列（WorkQueue）的大小
        executor.setQueueCapacity(5);
        // 设置线程池的大小
        executor.setMaxPoolSize(5);
        // 设置核心线程空闲超时后自动关闭。
        executor.setAllowCoreThreadTimeOut(true);
        // 设置任务进入WorkQueue，超过KeepAliveSeconds秒后会被自动销毁
        executor.setKeepAliveSeconds(60 * 10);
        // 线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住(示例等待10分钟)
        executor.setAwaitTerminationSeconds(60 * 10);
        // 设置线程名的前缀
        executor.setThreadNamePrefix("MyExecutor2_");
        // 设置线程池接收到负荷之外的任务时的处理策略(调用者执行策略)
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //如果不初始化，导致找到不到执行器
        executor.initialize();

        return executor;
    }
}
