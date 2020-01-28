package com.qh.common.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class WelcomeJob implements Job{
	
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WelcomeJob.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	logger.info("WelcomeJob,WelcomeJob!");
    }

}