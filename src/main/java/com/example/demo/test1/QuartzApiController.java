package com.example.demo.test1;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.rmi.server.ServerCloneException;

/**
 * @Program: QuartzJobScheduling
 * @Description:
 * @Author: wangwei
 * @Version:
 * @Create: 2019-04-03 09:22
 * @Updater: st.wu
 * @UpdateTime: 2019-04-03 09:22
 */
@RestController
@RequestMapping("/quartz")
public class QuartzApiController {
    @Resource
    private QuartzScheduler quartzScheduler;

    @PostMapping("/start")
    public void startQuartzJob() {
        try {
            quartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/info")
    public String getQuartzJob(@RequestBody InfoBean infoBean) {
        System.out.println("name:"+infoBean.getName()+" group :"+infoBean.getGroup());
        String info = null;
        try {
            info = quartzScheduler.getJobInfo(infoBean.getName(), infoBean.getGroup());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 修改某定时任务信息(quartz)
     * @return
     */
    @PostMapping("/modify")
    public boolean modifyQuartzJob(@RequestBody InfoBean infoBean) {
        boolean flag = true;
        try {
            flag = quartzScheduler.modifyJob(infoBean.getName(), infoBean.getGroup(), infoBean.getTime());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @PostMapping(value = "/pause")
    public void pauseQuartzJob(@RequestBody InfoBean infoBean) {
        try {
            quartzScheduler.pauseJob(infoBean.getName(), infoBean.getGroup());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/delete")
    public void deleteJob(@RequestBody InfoBean infoBean) {
        try {
            quartzScheduler.deleteJob(infoBean.getName(), infoBean.getGroup());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/add")
    public String add(@RequestBody InfoBean infoBean){
        quartzScheduler.addJob(infoBean.getName(),infoBean.getName(),"job1","group1",SchedulerQuartzJob1.class,infoBean.getTime(),infoBean.getUrl());
        return "success";
    }
}