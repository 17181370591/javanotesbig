package cn.me.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SeckillTask {

	@Scheduled(cron = "* * * * * * ?")
	public void refreshSeckillGoods() {
		System.out.println("执行了任务调度" + new Date());
	}
}