package course.concurrency.m2_async.executors.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncClassTest {

    @Autowired
    public AsyncConfig config;

    @Qualifier("taskExecutor1")
    private ThreadPoolTaskExecutor executor1;

    @Qualifier("taskExecutor2")
    private ThreadPoolTaskExecutor executor2;

    @Async("taskExecutor1")
    public void runAsyncTask() {
        System.out.println("runAsyncTask: " + Thread.currentThread().getName());
    }

    @Async("taskExecutor2")
    public void internalTask() {
        System.out.println("internalTask: " + Thread.currentThread().getName());
    }
}
