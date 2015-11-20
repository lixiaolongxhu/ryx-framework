/*
 * 告警管理类
 */
package com.sample.cometd;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sample.util.DateUtil;



/**
 * spring注解产生的bean是单例的，而每次处理告警进程的bean不应该是单例的，根据位置不同，产生的bran不应该一样
 * 
 * @author jianglan
 * 
 */
@Service
public class AlarmManager  {

	static Logger log = LoggerFactory.getLogger(AlarmManager.class);

	// Spring 容器接口
	private BeanFactory beanFactory;

	// 向客户端推送告警消息
	@Autowired
	private CometService cometService;
	
	

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	// 告警对象的队列
	private ConcurrentHashMap<String, String> alarmQueue = new ConcurrentHashMap<String, String>();

	// 定时任务入口
	/*
	 * 1、遍历队列，并执行相应的onTime过程， 2、把执行完的对象释放
	 */
	@Scheduled(fixedRate = 20*1000)
	public void nonTime() {
		log.info("定时任务入口");
//		cometService.clientNotify("alarm "+ DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
//		cometService.videoChannelNotify(" cometd 服务端广播消息  ");
		
		
	}
	


	/**
	 * 处理告警的入口 1.存储告警消息 2.将告警消息联动处理
	 * 
	 * @param infoBean
	 * 
	 *            抽象四个参数 1:resid 2:type 3:val1 4:val2
	 */
	public void onAlarm(int resid, int type, String val1, float val2) {



		String alarmKey = type + "." + resid;
		if (alarmQueue.containsKey(alarmKey)) {
			//alarmQueue.get(alarmKey).onAlarm(resid, type, val1, val2);
			log.debug("*重复告警--" + "资源：" + resid + ",类型：" + type + ",参数：" + val1);
		} else {
			cometService.clientNotify("alarm");
			log.info("push alarm");
			
			log.debug("+新建告警--" + "资源：" + resid + ",类型：" + type + ",参数：" + val1);
		}
	}
}
