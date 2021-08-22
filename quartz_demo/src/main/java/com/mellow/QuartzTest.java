package com.mellow;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
    public static void main(String[] args) throws Exception {
        // 由调度器工厂生成调度器对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // Scheduler调用start()方法
        scheduler.start();
        // 创建一个具体工作的对象
        JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class)
                //定义name和group 给触发器一些属性 比如名字，组名。
                .withIdentity("job1", "group1")
                //job需要传递的内容 具体job传递参数。
                .usingJobData("name", "sdas")
                .build();
        // 创建触发器对象
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                //加入 scheduler之后立刻执行 立刻启动
                .startNow()
                //定时 ，每隔1秒钟执行一次 以某种触发器触发。
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        //重复执行
                        .repeatForever()).build();

        scheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(6000);
        // Schedule停止
        scheduler.shutdown();

    }
}
