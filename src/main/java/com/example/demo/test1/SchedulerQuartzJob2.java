package com.example.demo.test1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Program: QuartzJobScheduling
 * @Description:
 * @Author: wangwei
 * @Version:
 * @Create: 2019-04-03 09:16
 * @Updater: st.wu
 * @UpdateTime: 2019-04-03 09:16
 */
public class SchedulerQuartzJob2 implements Job {
    private void before(){
        System.out.println("SchedulerQuartzJob2任务开始执行");
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        before();
        System.out.println("开始："+System.currentTimeMillis());
        // TODO 业务
        System.out.println("结束："+System.currentTimeMillis());
        after();
    }
    private void after(){
        System.out.println("SchedulerQuartzJob2任务开始执行");
    }
}