package com.example.demo.test1;

import org.quartz.Job;
import org.quartz.JobDataMap;
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
public class SchedulerQuartzJob1 implements Job {
    private void before(){
        System.out.println("SchedulerQuartzJob1任务开始执行");
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        before();
        System.out.println("开始："+System.currentTimeMillis());
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("业务参数："+dataMap.getString("data1"));

        // TODO 业务
        System.out.println("结束："+System.currentTimeMillis());
        after();
    }
    private void after(){
        System.out.println("任务开始执行");
    }
}