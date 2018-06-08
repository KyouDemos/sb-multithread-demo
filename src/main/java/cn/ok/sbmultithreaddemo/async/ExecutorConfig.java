package cn.ok.sbmultithreaddemo.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义异步任务执行器
 *
 * @author kyou at 2018/6/6 15:57
 */
@Configuration
public class ExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 设置核心线程池大小
        executor.setCorePoolSize(10);
        // 设置核心线程池的等待队列（WorkQueue）的大小
        executor.setQueueCapacity(10);
        // 设置线程池的大小
        executor.setMaxPoolSize(20);
        // 设置核心线程空闲超时后自动关闭。
        executor.setAllowCoreThreadTimeOut(true);
        // 设置任务进入WorkQueue，超过KeepAliveSeconds秒后会被自动销毁
        executor.setKeepAliveSeconds(60 * 10);
        // 线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住(示例等待10分钟)
        executor.setAwaitTerminationSeconds(60 * 10);
        // 设置线程名的前缀
        executor.setThreadNamePrefix("MyExecutor1_");
        // 设置线程池接收到负荷之外的任务时的处理策略(调用者执行策略)
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //如果不初始化，导致找到不到执行器
        executor.initialize();

        return executor;
    }

    @Bean(name = "MyExecutor2")
    public Executor initMyExecutor2(){
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

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}